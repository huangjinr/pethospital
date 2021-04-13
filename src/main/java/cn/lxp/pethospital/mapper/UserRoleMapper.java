package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRoleMapper {
    void insertUserRole(UserRole userRole);

    void updateRoleIdByUserId(UserRole userRole);
}
