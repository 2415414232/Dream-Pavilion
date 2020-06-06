package com.dangle.Dao;

import com.dangle.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/12/20
 */
@Mapper
public interface userDao {
    void addUser(User user);
    User login(String uname);

    public String getRole(Integer ridd);

    List<User> findUser();

    void deleteUser(Integer uid);
}
