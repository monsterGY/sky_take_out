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
public interface SetmealMapper {
    /**
     * 根据分类id查询套餐的数
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategory(Long id);
}
