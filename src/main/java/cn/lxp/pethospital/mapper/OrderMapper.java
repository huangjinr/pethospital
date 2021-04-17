package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    List<OrderDTO> selectOrderList();

    int insertOrder(OrderDTO orderDTO);

    List<OrderDTO> selectOrderListByBuyId(String id);

    int deleteOrderByBuyId(String id);
}
