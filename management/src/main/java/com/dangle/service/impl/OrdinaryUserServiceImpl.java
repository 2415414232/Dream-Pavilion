package com.dangle.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.dangle.Dao.OrdinaryUserDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.OrdinaryUser;
import com.dangle.service.OrdinaryUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/9/24
 * 用户模块
 */
@Service
public class OrdinaryUserServiceImpl implements OrdinaryUserService {
    @Autowired
    private OrdinaryUserDao mapper;
    @Override
    public pageEntity<OrdinaryUser> selectedAlluser(Integer page, Integer size,OrdinaryUser user) {
        PageHelper.startPage(page,size);
        Page<OrdinaryUser> pageinfo = (Page<OrdinaryUser>) mapper.selectedAlluser(user);


        pageEntity<OrdinaryUser> pageEntity=new pageEntity<>();
       pageEntity.setNums(pageinfo.getTotal()).setTotalpages(pageinfo.getPages()).setList(pageinfo.getResult());
        return pageEntity;
    }

    @Override
    public void prohibitUser(Long id) {
        mapper.prohibitUser(id);
    }

    @Override
    public void actiivationUser(Long id) {
        mapper.actiivationUser(id);
    }
}
