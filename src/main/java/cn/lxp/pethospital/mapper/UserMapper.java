package cn.lxp.pethospital.mapper;

import cn.lxp.pethospital.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> selectUserList();

    int insertUser(User user);

    User selectUserById(String id);

    int updateUser(User user);

    int deleteUserById(String id);
}
