package cn.lxp.pethospital.service.impl;

import cn.lxp.pethospital.mapper.OrderMapper;
import cn.lxp.pethospital.model.OrderDTO;
import cn.lxp.pethospital.model.OrderVO;
import cn.lxp.pethospital.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderVO> selectOrderList() {
        List<OrderDTO> orderDTOList = orderMapper.selectOrderList();
        List<OrderVO> orderVOList = new ArrayList<>();
        for (OrderDTO orderDTO : orderDTOList) {
            Boolean flag = true;
            for (OrderVO orderVO : orderVOList) {
                if (orderVO.getId().equals(orderDTO.getBuyId())){
                    orderVO.setDrugName(orderVO.getDrugName()+","+orderDTO.getDrug().getDrugName());
                    orderVO.setTotalPrice(orderVO.getTotalPrice()+orderDTO.getOrderSize()*orderDTO.getDrug().getDrugPrice());
                    flag = false;
                }
            }
            if (flag){
                OrderVO orderVO = new OrderVO();
                orderVO.setId(orderDTO.getBuyId());
                orderVO.setTotalPrice(orderDTO.getDrug().getDrugPrice()*orderDTO.getOrderSize());
                orderVO.setDrugName(orderDTO.getDrug().getDrugName());
                orderVO.setAnimal(orderDTO.getUser().getAnimal());
                orderVO.setAnimalName(orderDTO.getUser().getAnimalName());
            }
        }
        return orderVOList;
    }
}
