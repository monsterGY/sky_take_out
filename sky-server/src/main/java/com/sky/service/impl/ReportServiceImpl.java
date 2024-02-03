package com.sky.service.impl;

import com.sky.dto.GoodsSalesDTO;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.mapper.UserMapper;
import com.sky.service.ReportService;
import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/03  12:05
 */
@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    /**
     * 统计指定时间区间内的营业额数据
     * @param begin
     * @param end
     * @return
     */
    public TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end) {
        List<LocalDate> dateList =new ArrayList<>();

        dateList.add(begin);
        while (!begin.equals(end)){
            begin=begin.plusDays(1);
            dateList.add(begin);
        }
        String join = StringUtils.join(dateList, ",");

        List<Double> turnoverList= new ArrayList<>();
        for (LocalDate localDate : dateList) {
            LocalDateTime beginTime = LocalDateTime.of(localDate, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(localDate, LocalTime.MAX);

            Map map=new HashMap<>();
            map.put("begin",beginTime);
            map.put("end",endTime);
            map.put("status", Orders.COMPLETED);
            Double turnover = orderMapper.sumByMap(map);
            turnover= turnover==null? 0.0:turnover;

            turnoverList.add(turnover);
        }

        return TurnoverReportVO.builder()
                .dateList(join)
                .turnoverList(StringUtils.join(turnoverList, ","))
                .build();
    }

    @Override
    public UserReportVO getUserStatistics(LocalDate begin, LocalDate end) {
        List<LocalDate> dateList =new ArrayList<>();

        dateList.add(begin);
        while (!begin.equals(end)){
            begin=begin.plusDays(1);
            dateList.add(begin);
        }
        String join = StringUtils.join(dateList, ",");

        List<Integer> newUserList=new ArrayList<>();

        for (LocalDate localDate : dateList) {
            LocalDateTime beginTime = LocalDateTime.of(localDate, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(localDate, LocalTime.MAX);

            Map map=new HashMap<>();
            map.put("begin",beginTime);
            map.put("end",endTime);
            Integer countByMap = userMapper.countByMap(map);

            countByMap= countByMap==null? 0:countByMap;

            newUserList.add(countByMap);
        }
        List<Integer> totalUserList=new ArrayList<>();
        for (LocalDate localDate : dateList) {

            LocalDateTime endTime = LocalDateTime.of(localDate, LocalTime.MAX);

            Map map=new HashMap<>();
            map.put("end",endTime);
            Integer countByMap = userMapper.countByMap(map);

            countByMap= countByMap==null? 0:countByMap;

            totalUserList.add(countByMap);
        }


        return UserReportVO.builder()
                .dateList(join)
                .newUserList(StringUtils.join(newUserList, ","))
                .totalUserList(StringUtils.join(totalUserList, ","))
                .build();
    }

    @Override
    public OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end) {
        List<LocalDate> dateList =new ArrayList<>();

        dateList.add(begin);
        while (!begin.equals(end)){
            begin=begin.plusDays(1);
            dateList.add(begin);
        }
        String join = StringUtils.join(dateList, ",");

        List<Integer> orderList=new ArrayList<>();
        List<Integer> validOrderList=new ArrayList<>();
        //查询每天的订单数和订单总数
        for (LocalDate localDate : dateList) {
            LocalDateTime beginTime = LocalDateTime.of(localDate, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(localDate, LocalTime.MAX);
            Integer orderCount = getOrderCount(beginTime, endTime, null);
            orderList.add(orderCount);
            Integer validOrderCount = getOrderCount(beginTime, endTime, Orders.COMPLETED);
            validOrderList.add(orderCount);

        }
        Integer totalOrderCount = orderList.stream().reduce(Integer::sum).get();
        Integer totalValidOrderCount = validOrderList.stream().reduce(Integer::sum).get();

        Double orderCompletionRate=0.0;
        if(totalOrderCount!=0) {
            orderCompletionRate = totalValidOrderCount.doubleValue() / totalOrderCount;

        }

        return OrderReportVO.builder()
                .dateList(join)
                .totalOrderCount(totalOrderCount)
                .orderCompletionRate(orderCompletionRate)
                .validOrderCount(totalValidOrderCount)
                .orderCountList(StringUtils.join(orderList, ","))
                .validOrderCountList(StringUtils.join(validOrderList, ","))
                .build();
    }

    private Integer getOrderCount( LocalDateTime beginTime,
                                   LocalDateTime endTime,
                                    Integer status){
        Map map=new HashMap<>();
        map.put("begin",beginTime);
        map.put("end",endTime);
        map.put("status",status);
        return orderMapper.countByMap(map);
    }

    @Override
    public SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end) {
        LocalDateTime beginTime = LocalDateTime.of(begin, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(end, LocalTime.MAX);

        List<GoodsSalesDTO> salesTop10 = orderMapper.getSalesTop10(beginTime, endTime);
        List<String> names = salesTop10.stream().map(GoodsSalesDTO::getName).collect(Collectors.toList());
        String nameList = StringUtils.join(names, ",");

        List<Integer> numbers = salesTop10.stream().map(GoodsSalesDTO::getNumber).collect(Collectors.toList());
        String numberList = StringUtils.join(numbers, ",");



        return SalesTop10ReportVO.builder()
                .nameList(nameList)
                .numberList(numberList)
                .build();
    }
}
