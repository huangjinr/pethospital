package cn.lxp.pethospital.service;

import cn.lxp.pethospital.mapper.SaleMapper;
import cn.lxp.pethospital.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Sale> selectSaleList() {
        return saleMapper.selectSaleList();
    }
}
