package com.dangle.service.impl;

import com.dangle.Dao.userDao;
import com.dangle.pojo.User;
import com.dangle.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by 党桢乐 on 2019/12/20
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private userDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
