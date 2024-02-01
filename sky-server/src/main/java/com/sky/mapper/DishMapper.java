package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/01  0:17
 */
@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategory(Long categoryId);
}