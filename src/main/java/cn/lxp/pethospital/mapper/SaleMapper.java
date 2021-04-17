package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SaleMapper {
    List<Sale> selectSaleList();
}
