package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.DrugMapper;
import cn.lxp.pethospital.model.Drug;
import cn.lxp.pethospital.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drug> selectDrugList() {
        return drugMapper.selectDrugList();
    }

    @Override
    public int insertDrug(Drug drug) {
        drug.setIsDel(0);
        drug.setId(IdUtil.simpleUUID());
        return drugMapper.insertDrug(drug);
    }

    @Override
    public Drug selectDrugById(String id) {
        return drugMapper.selectDrugById(id);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugMapper.updateDrug(drug);
    }

    @Override
    public int deleteDrugById(String id) {
        return drugMapper.deleteDrugById(id);
    }
}
