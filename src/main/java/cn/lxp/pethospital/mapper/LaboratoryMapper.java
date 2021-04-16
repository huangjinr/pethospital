package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.Laboratory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LaboratoryMapper {
    List<Laboratory> selectLaboratoryList();

    int insertLaboratory(Laboratory laboratory);

    Laboratory selectLaboratoryById(String id);

    int updateLaboratory(Laboratory laboratory);

    int deleteLaboratoryById(String id);
}
