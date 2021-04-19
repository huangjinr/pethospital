package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.Laboratory;

import java.util.List;

public interface LaboratoryService {
    List<Laboratory> selectLaboratoryList(String name,String animalName);

    int insertLaboratory(Laboratory laboratory);

    Laboratory selectLaboratoryById(String id);

    int updateLaboratory(Laboratory laboratory);

    int deleteLaboratoryById(String id);
}
