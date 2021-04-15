package cn.lxp.pethospital.service.impl;

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
}
