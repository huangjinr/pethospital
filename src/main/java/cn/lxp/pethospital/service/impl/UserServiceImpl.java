package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.RoleMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.mapper.UserRoleMapper;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.model.UserRole;
import cn.lxp.pethospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public int insertUser(User user) {
        String userId = IdUtil.simpleUUID();
        user.setId(userId);
        user.setIsDel(0);
        String roleId = roleMapper.selectRoleIdByRoleType(user.getRole().getRoleType());
        UserRole userRole = new UserRole();
        userRole.setId(IdUtil.simpleUUID());
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        userRole.setisDel(0);
        userRoleMapper.insertUserRole(userRole);
        return userMapper.insertUser(user);
    }

    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUser(User user) {
        String roleId = roleMapper.selectRoleIdByRoleType(user.getRole().getRoleType());
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleId);
        userRoleMapper.updateRoleIdByUserId(userRole);
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }
}
