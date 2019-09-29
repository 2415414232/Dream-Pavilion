package com.dangle.service;



import com.dangle.Dao.OrdinaryUserDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.OrdinaryUser;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/9/24
 * 普通用户模块
 */
public interface OrdinaryUserService {
    pageEntity<OrdinaryUser> selectedAlluser(Integer page, Integer size, OrdinaryUser user);

    void prohibitUser(Long id);

    void actiivationUser(Long id);
}
