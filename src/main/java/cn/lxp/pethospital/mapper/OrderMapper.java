package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderMapper {
    List<OrderDTO> selectOrderList(Map<String,Object> map);

    int insertOrder(OrderDTO orderDTO);

    List<OrderDTO> selectOrderListByBuyId(String id);

    int deleteOrderByBuyId(String id);
}
