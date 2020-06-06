package com.dangle.Dao;

import com.dangle.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author by 党桢乐 on 2020/5/13
 */
@Mapper
public interface goodsDao {
    void saveGoods(Goods goods);

    void deleteGoods(Integer id);

    Goods findGoodsById(Integer id);

    void updateGoods(Goods goods);

    Integer findordernum(String time);

    Integer findconsumernum();
}
