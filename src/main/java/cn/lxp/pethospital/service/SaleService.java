package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> selectSaleList(String drugName);
}
