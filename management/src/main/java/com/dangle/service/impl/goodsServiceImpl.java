package com.dangle.service.impl;

import com.dangle.Dao.goodsDao;
import com.dangle.entity.Time;
import com.dangle.entity.WoExecutor;
import com.dangle.pojo.Goods;
import com.dangle.service.goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @author by 党桢乐 on 2020/5/13
 */
@Service
public class goodsServiceImpl implements goodsService {
    @Autowired
    private goodsDao goodsDao;
    @Override
    public void saveGoods(Goods goods) {
        goodsDao.saveGoods(goods);
    }

    @Override
    public void deleteGoods(Integer id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public Goods findGoodsById(Integer id) {
        return goodsDao.findGoodsById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public Map findordernum() throws  Exception {
        ExecutorService executor = WoExecutor.getExecutor();
        FutureTask<Integer> aaa=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return goodsDao.findordernum(Time.getTime());
            }
        });
        executor.submit(aaa);
        Map map=new HashMap();
        DecimalFormat aa=new DecimalFormat("0.00");
        Integer a=aaa.get();
        Integer b=goodsDao.findconsumernum();
        if(b==0){
            b=1;
        }
        map.put("a",a);
        map.put("b",aa.format((float)a/b));

        return map;
    }
}
