package com.dangle.service;

import com.dangle.entity.pageEntity;
import com.dangle.pojo.Consumer;

import java.util.List;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/9/30
 */
public interface consumerService {
    pageEntity<Consumer> findAll(Integer page, Integer size,Consumer consumer);

    List<Map> findService();

    Consumer findOne(Long id);

    void editConsumer(Consumer consumer);

    void saveConsumer(Consumer consumer);

    List<Map> findConsumer();
}
