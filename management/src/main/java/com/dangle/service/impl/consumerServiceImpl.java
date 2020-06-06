package com.dangle.service.impl;

import com.dangle.Dao.consumerDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Consumer;
import com.dangle.pojo.Goods;
import com.dangle.service.consumerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Goods> findService() {
        return consumerdao.findService();
    }

    @Override
    public Consumer findOne(Long id) {
        return consumerdao.findOne(id);
    }

    @Override
    public void editConsumer(Consumer consumer) {
        if(consumer.getConstatus().equalsIgnoreCase("1") && consumer.getConstatus().length()>0){
            SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
                consumer.setEndtime(format.format(new Date()));
    }
        consumerdao.editConsumer(consumer);
    }

    @Override
    public void saveConsumer(Consumer consumer) {
        consumer.setConstatus("0");
        consumerdao.saveConsumer(consumer);
    }

    @Override
    public List<Map> findConsumer() {
        return consumerdao.findConsumer();
    }
}
