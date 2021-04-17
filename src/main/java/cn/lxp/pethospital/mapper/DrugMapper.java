package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.Drug;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DrugMapper {
    public List<Drug> selectDrugList();

    int insertDrug(Drug drug);

    Drug selectDrugById(String id);

    int updateDrug(Drug drug);

    int deleteDrugById(String id);

    Drug selectDrugByName(String DrugName);
}
