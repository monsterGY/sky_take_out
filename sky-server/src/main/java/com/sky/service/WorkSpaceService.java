package com.sky.service;

import com.sky.vo.BusinessDataVO;
import com.sky.vo.DishOverViewVO;
import com.sky.vo.OrderOverViewVO;
import com.sky.vo.SetmealOverViewVO;

import java.time.LocalDateTime;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/03  16:41
 */
public interface WorkSpaceService {

    BusinessDataVO getBusinessData(LocalDateTime begin, LocalDateTime end);

    OrderOverViewVO getOrderOverView();

    DishOverViewVO getDishOverView();

    SetmealOverViewVO getSetmealOverView();
}
