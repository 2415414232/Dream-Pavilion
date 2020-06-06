package com.dangle.service.impl;

import com.dangle.Dao.userDao;
import com.dangle.pojo.User;
import com.dangle.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/12/20
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private userDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addUser(User user) {
        System.out.println(user);
        user.setUpassword(bCryptPasswordEncoder.encode(user.getUpassword()));//密码加密
        System.out.println(user);
        userDao.addUser(user);
    }

    @Override
    public User login(User user) {
        User users= userDao.login(user.getUname());
        if(users!=null && bCryptPasswordEncoder.matches(user.getUpassword(),users.getUpassword())){
            return users;
        }else{

            return null;
        }
    }

    @Override
    public String getRole(Integer rid) {
        return userDao.getRole(rid);
    }

    @Override
    public List<User> findUser() {
        return userDao.findUser();
    }

    @Override
    public void deleteUser(Integer uid) {
        userDao.deleteUser(uid);
    }
}
