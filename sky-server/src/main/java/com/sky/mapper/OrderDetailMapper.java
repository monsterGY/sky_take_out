package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  16:25
 */
@Mapper
public interface OrderDetailMapper {

    void insertBatch(ArrayList<OrderDetail> orderDetailArrayList);
}
