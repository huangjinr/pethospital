package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.RoleMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.mapper.UserRoleMapper;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.model.UserRole;
import cn.lxp.pethospital.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> selectUserList(String name,String username,String phone) {
        Map<String, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        if (currentUser.getRole().getRoleType() != 1){
            map.put("roleType",2);
            //map.put("id",currentUser.getId());
        }
        if (name != null && !"".equals(name)){
            map.put("name",name);
        }
        if (username != null && !"".equals(username)){
            map.put("username",username);
        }
        if (phone != null && !"".equals(phone)){
            map.put("phone",phone);
        }
        return userMapper.selectUserList(map);
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

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public int setUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserPassword(User user) {
        return userMapper.updateUser(user);
    }
}
