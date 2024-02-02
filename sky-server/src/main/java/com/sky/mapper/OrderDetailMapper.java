package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  16:25
 */
@Mapper
public interface OrderDetailMapper {

    void insertBatch(ArrayList<OrderDetail> orderDetailArrayList);

    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> getByOrderId(Long orderId);
}
