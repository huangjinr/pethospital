package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.Drug;

import java.util.List;

public interface DrugService {
    List<Drug> selectDrugList();

    int insertDrug(Drug drug);

    Drug selectDrugById(String id);

    int updateDrug(Drug drug);

    int deleteDrugById(String id);
}
