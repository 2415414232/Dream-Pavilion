package com.dangle.service;

import com.dangle.entity.pageEntity;
import com.dangle.pojo.Consumer;

/**
 * @author by 党桢乐 on 2019/9/30
 */
public interface consumerService {
    pageEntity<Consumer> findAll(Integer page, Integer size,Consumer consumer);
}
