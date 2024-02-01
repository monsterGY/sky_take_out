package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/01  11:37
 */
public interface DIshService {
    /**
     * 新增菜品和对应的口味数据
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
