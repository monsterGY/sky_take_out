package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  16:24
 */
@Mapper
public interface OrderMapper {
    void insert(Orders orders);
}
