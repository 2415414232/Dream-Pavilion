package com.dangle.controller;

import com.dangle.entity.pageEntity;
import com.dangle.pojo.Consumer;
import com.dangle.service.consumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by 党桢乐 on 2019/9/30
 */
@RestController
@RequestMapping("/consumer")
public class consumerController {
    @Autowired
    private consumerService consumerservice;
    @RequestMapping("/findAll/{page}/{size}")
    public pageEntity findAll(@PathVariable Integer page, @PathVariable Integer size, @RequestBody Consumer consumer){
        return consumerservice.findAll(page,size,consumer);
    }
}
