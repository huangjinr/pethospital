package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.OrderVO;

import java.util.List;

public interface OrderService {
    List<OrderVO> selectOrderList();

    int insertOrder(OrderVO orderVO);

    OrderVO selectOrderById(String id);

    int updateOrder(OrderVO orderVO);

    int deleteOrderByBuyId(String id);
}
