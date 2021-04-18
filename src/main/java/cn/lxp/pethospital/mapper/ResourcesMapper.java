package cn.lxp.pethospital.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResourcesMapper {
    List<String> selectResourcesCodeByUserId(String id);
}
