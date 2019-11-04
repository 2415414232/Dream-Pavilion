package com.dangle.controller;

import com.dangle.entity.Result;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Conorder;
import com.dangle.service.conorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/11/4
 */
@RestController
@RequestMapping("/conorder")
public class conorderController {
    @Autowired
    private conorderService conorderService;
    @RequestMapping("/find/{page}/{size}")
    public pageEntity<Conorder> find(@PathVariable Integer page,@PathVariable Integer size, @RequestBody Map<String,String> conditionmap){
        pageEntity<Conorder> pages = conorderService.findAll(page, size, conditionmap);
        return pages;
    }
    @RequestMapping("/saveOrder")
    public  Result saveOrder(@RequestBody Conorder conorder){
        conorderService.saveOrder(conorder);
        return Result.success().addmessage("msg","添加成功");

    }
}
