package com.dangle.service;

import com.dangle.Dao.conorderDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Conorder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/11/4
 */
public interface conorderService {


    pageEntity<Conorder> findAll(Integer page, Integer size, Map<String, String> conditionmap);

    void saveOrder(Conorder conorder);
}
