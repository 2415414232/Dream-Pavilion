package com.dangle.service;

import com.dangle.pojo.Goods;

import java.util.Map;

/**
 * @author by 党桢乐 on 2020/5/13
 */
public interface goodsService {

    void saveGoods(Goods goods);

    void deleteGoods(Integer id);

    Goods findGoodsById(Integer id);
    void updateGoods(Goods goods);

    Map findordernum() throws Exception;
}
