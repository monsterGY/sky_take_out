package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/01  12:24
 */
@Mapper
public interface SetmealDishMapper {



    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据菜品id查询对应套餐id
     * @param dishIds
     * @return
     */

    List<Long> getSetmealIdByDishIds(List<Long> dishIds);

    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);

    @Select("select * from setmeal_dish where setmeal_id = #{id}")
    List<SetmealDish> getBySetmealId(Long id);


}
