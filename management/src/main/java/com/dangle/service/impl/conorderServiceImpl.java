package com.dangle.service.impl;

import com.dangle.Dao.conorderDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Conorder;
import com.dangle.service.conorderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author by 党桢乐 on 2019/11/4
 */
@Service
public class conorderServiceImpl implements conorderService
{
    @Autowired
    private conorderDao conorderDao;

    @Override
    public pageEntity<Conorder> findAll(Integer page, Integer size, Map<String, String> conditionmap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date=sdf.format(new Date());
        if (conditionmap.containsKey("ordtime")) {
            if (conditionmap.get("ordtime").equals("1")) {
                date = sdf.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));

            }
            if (conditionmap.get("ordtime").equals("2")) {
                date="all";
            }
            conditionmap.remove("ordtime");
        }
        conditionmap.put("time",date);
        PageHelper.startPage(page,size);
        Page<Conorder> pageinfo= (Page<Conorder>) conorderDao.findAll(conditionmap);
        pageEntity<Conorder> entity=new pageEntity<>();
        entity.setNums(pageinfo.getTotal()).setTotalpages(pageinfo.getPages()).setList(pageinfo.getResult());
        return entity;

    }

    @Override
    public void saveOrder(Conorder conorder) {
          if(conorder.getOrdIntroduce()==null){
            conorder.setOrdIntroduce("无备注！");
        }
        conorderDao.saveOrder(conorder);
    }

    @Override
    public Conorder editOne(Long id) {
        return conorderDao.editOne(id);
    }

    @Override
    public void editOrder(Conorder conorder) {
        conorderDao.editOrder(conorder);
    }

    @Override
    public void deleteOrder(Long[] delete) {

        conorderDao.deleteOrder(delete);
    }


}
