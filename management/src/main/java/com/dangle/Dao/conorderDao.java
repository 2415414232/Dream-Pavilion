package com.dangle.Dao;

import com.dangle.pojo.Conorder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/11/4
 */
@Mapper
@Component("conorderDao")
public interface conorderDao {
    List<Conorder> findAll( Map<String, String> conditionmap);

    void saveOrder(Conorder conorder);
}
