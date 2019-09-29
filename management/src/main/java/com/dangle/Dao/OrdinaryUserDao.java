package com.dangle.Dao;

import com.dangle.pojo.OrdinaryUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/9/24
 * 普通用户模块
 */
@Mapper
@Component("ordinaryUserDao")
public interface OrdinaryUserDao {
     List<OrdinaryUser> selectedAlluser(OrdinaryUser user);

    void prohibitUser(Long id);

    void actiivationUser(Long id);
}
