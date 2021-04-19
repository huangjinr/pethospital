package cn.lxp.pethospital.service;

import cn.lxp.pethospital.model.User;

import java.util.List;

public interface UserService {
    List<User> selectUserList(String name,String username,String phone);

    int insertUser(User user);

    User selectUserById(String id);

    int updateUser(User user);

    int deleteUserById(String id);

    User selectUserByUsername(String username);

    int setUser(User user);

    int updateUserPassword(User user);
}
