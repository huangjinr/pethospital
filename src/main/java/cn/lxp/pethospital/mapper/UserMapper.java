package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {
    List<User> selectUserList(Map<String,Object> map);

    int insertUser(User user);

    User selectUserById(String id);

    int updateUser(User user);

    int deleteUserById(String id);

    User selectUserByName(String name);

    User selectUserByUsername(String username);

}
