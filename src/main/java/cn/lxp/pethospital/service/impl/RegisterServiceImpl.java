package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.RoleMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.mapper.UserRoleMapper;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.model.UserRole;
import cn.lxp.pethospital.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer insertUser(User user) {
        String userId = IdUtil.simpleUUID();
        user.setId(userId);
        user.setIsDel(0);
        String roleId = roleMapper.selectRoleIdByRoleType(2);
        UserRole userRole = new UserRole();
        userRole.setId(IdUtil.simpleUUID());
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        userRole.setisDel(0);
        userRoleMapper.insertUserRole(userRole);
        return userMapper.insertUser(user);
    }
}
