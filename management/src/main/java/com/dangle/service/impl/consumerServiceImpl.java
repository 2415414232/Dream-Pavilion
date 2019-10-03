package com.dangle.service.impl;

import com.dangle.Dao.consumerDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Consumer;
import com.dangle.service.consumerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by 党桢乐 on 2019/9/30
 */
@Service
public class consumerServiceImpl  implements consumerService {
    @Autowired
    private consumerDao consumerdao;

    @Override
    public pageEntity<Consumer> findAll(Integer page, Integer size,Consumer consumer) {
        PageHelper.startPage(page,size);
        Page<Consumer> pageinfo= (Page<Consumer>) consumerdao.findAll(consumer);
        pageEntity<Consumer> entity=new pageEntity<>();
        entity.setNums(pageinfo.getTotal()).setTotalpages(pageinfo.getPages()).setList(pageinfo.getResult());
        return entity;
    }
}
