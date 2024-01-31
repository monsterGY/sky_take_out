package com.sky.service;

import com.sky.dto.CategoryDTO;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/01  0:03
 */
public interface CategoryService {
    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);
}
