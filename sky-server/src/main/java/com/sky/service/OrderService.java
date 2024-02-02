package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  16:20
 */
public interface OrderService {

    OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO);
}
