package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.DrugMapper;
import cn.lxp.pethospital.mapper.OrderMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.model.Drug;
import cn.lxp.pethospital.model.OrderDTO;
import cn.lxp.pethospital.model.OrderVO;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<OrderVO> selectOrderList() {
        List<OrderDTO> orderDTOList = orderMapper.selectOrderList();
        List<OrderVO> orderVOList = new ArrayList<>();
        for (OrderDTO orderDTO : orderDTOList) {
            Boolean flag = true;
            for (OrderVO orderVO : orderVOList) {
                if (orderVO.getId().equals(orderDTO.getBuyId())) {
                    orderVO.setDrugName(orderVO.getDrugName() + "," + orderDTO.getDrug().getDrugName() + "*" + orderDTO.getOrderSize());
                    orderVO.setTotalPrice(orderVO.getTotalPrice() + orderDTO.getOrderSize() * orderDTO.getDrug().getDrugPrice());
                    flag = false;
                }
            }
            if (flag) {
                OrderVO orderVO = new OrderVO();
                orderVO.setId(orderDTO.getBuyId());
                orderVO.setTotalPrice(orderDTO.getDrug().getDrugPrice() * orderDTO.getOrderSize());
                orderVO.setDrugName(orderDTO.getDrug().getDrugName() + "*" + orderDTO.getOrderSize());
                orderVO.setUserName(orderDTO.getUser().getName());
                orderVO.setAnimal(orderDTO.getUser().getAnimal());
                orderVO.setAnimalName(orderDTO.getUser().getAnimalName());
                orderVOList.add(orderVO);
            }
        }
        return orderVOList;
    }

    @Override
    public int insertOrder(OrderVO orderVO) {
        User user = userMapper.selectUserByName(orderVO.getUserName());
        if (user == null) {
            return 0;
        }
        String drugName = orderVO.getDrugName();
        String[] drugNameSplit = drugName.split("，");
        if (drugNameSplit.length == 1) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(IdUtil.simpleUUID());
            orderDTO.setBuyId(IdUtil.simpleUUID());
            orderDTO.setUserId(user.getId());
            orderDTO.setIsDel(0);
            String[] split = orderVO.getDrugName().split("\\*");
            orderDTO.setOrderSize(Integer.valueOf(split[1]));
            Drug drug = drugMapper.selectDrugByName(split[0]);
            if (drug == null) {
                return 0;
            }
            orderDTO.setDrugId(drug.getId());
            orderDTO.setOrderPrice(drug.getDrugPrice()*Integer.valueOf(split[1]));
            return orderMapper.insertOrder(orderDTO);
        }
        String buyId = IdUtil.simpleUUID();
        for (String name : drugNameSplit) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(IdUtil.simpleUUID());
            orderDTO.setBuyId(buyId);
            orderDTO.setUserId(user.getId());
            orderDTO.setIsDel(0);
            String[] split = name.split("\\*");
            orderDTO.setOrderSize(Integer.valueOf(split[1]));
            Drug drug = drugMapper.selectDrugByName(split[0]);
            if (drug == null) {
                return 0;
            }
            orderDTO.setDrugId(drug.getId());
            orderDTO.setOrderPrice(drug.getDrugPrice()*Integer.valueOf(split[1]));
            orderMapper.insertOrder(orderDTO);
        }
        return 1;
    }

    @Override
    public OrderVO selectOrderById(String id) {
        List<OrderDTO> orderDTOList = orderMapper.selectOrderListByBuyId(id);
        OrderVO orderVO = new OrderVO();
        for (OrderDTO orderDTO : orderDTOList) {
            orderVO.setId(orderDTO.getBuyId());
            if(orderVO.getDrugName() != null && !"".equals(orderVO.getDrugName())){
                orderVO.setDrugName(orderVO.getDrugName()+"，"+orderDTO.getDrug().getDrugName() + "*" + orderDTO.getOrderSize());
            }else {
                orderVO.setDrugName(orderDTO.getDrug().getDrugName() + "*" + orderDTO.getOrderSize());
            }
            orderVO.setUserName(orderDTO.getUser().getName());
        }
        return orderVO;
    }

    @Override
    public int updateOrder(OrderVO orderVO) {
        deleteOrderByBuyId(orderVO.getId());
        return insertOrder(orderVO);
    }

    @Override
    public int deleteOrderByBuyId(String id) {
        return orderMapper.deleteOrderByBuyId(id);
    }


}
