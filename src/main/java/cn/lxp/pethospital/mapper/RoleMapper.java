package cn.lxp.pethospital.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper {
    String selectRoleIdByRoleType(Integer roleType);
}
