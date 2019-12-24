package com.dangle.Dao;

import com.dangle.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author by 党桢乐 on 2019/12/20
 */
@Mapper
public interface userDao {
    void addUser(User user);
    User login(String uname);

    public String getRole(Integer ridd);
}
