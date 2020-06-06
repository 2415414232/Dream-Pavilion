package com.dangle.service;

import com.dangle.pojo.User;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/12/20
 */
public interface userService {
    void addUser(User user);
    public User login(User user);

    String getRole(Integer rid);

    List<User> findUser();

    void deleteUser(Integer uid);
}
