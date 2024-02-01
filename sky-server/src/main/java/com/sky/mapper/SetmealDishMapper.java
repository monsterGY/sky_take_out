package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/01  12:24
 */
@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应套餐id
     * @param dishIds
     * @return
     */

    List<Long> getSetmealIdByDishIds(List<Long> dishIds);
}
