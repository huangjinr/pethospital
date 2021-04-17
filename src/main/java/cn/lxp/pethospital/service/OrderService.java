package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.OrderVO;

import java.util.List;

public interface OrderService {
    List<OrderVO> selectOrderList();
}
