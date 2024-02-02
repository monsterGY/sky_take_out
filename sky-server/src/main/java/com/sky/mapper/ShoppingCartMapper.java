package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  10:41
 */
@Mapper

public interface ShoppingCartMapper {

    /**
     * 条件查询
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 更新商品数量
     * @param shoppingCart
     */
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 插入购物车数据
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);

    /**
     * 清空购物车商品
     * @param currentId
     */
    void deleteByUserId(Long currentId);

    /**
     * 根据id删除商品
     * @param id
     */
    void deleteById(Long id);

    /**
     * 将购物车对象批量添加到购物车
     * @param shoppingCartList
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
