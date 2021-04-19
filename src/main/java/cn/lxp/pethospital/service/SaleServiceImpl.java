package cn.lxp.pethospital.service;

import cn.lxp.pethospital.mapper.SaleMapper;
import cn.lxp.pethospital.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Sale> selectSaleList(String drugName) {
        Map<String, Object> map = new HashMap<>();
        if (drugName != null && !"".equals(drugName)){
            map.put("drugName",drugName);
        }
        return saleMapper.selectSaleList(map);
    }
}
