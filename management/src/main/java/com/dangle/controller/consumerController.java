package com.dangle.controller;

import com.dangle.entity.Result;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Consumer;
import com.dangle.service.consumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    @RequestMapping("/findService")
    public List<Map> findService(){
        return consumerservice.findService();
    }

    @RequestMapping("/findOne/{id}")
    public  Consumer findOne(@PathVariable Long id){
        return consumerservice.findOne(id);
    }
    @RequestMapping("/editConsumer")
    public  Result editConsumer(@RequestBody Consumer consumer){
        try {
            System.out.println(consumer);
            consumerservice.editConsumer(consumer);
            return  Result.success().addmessage("msg","修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail().addmessage("msg","修改失败");
        }
    }


    @RequestMapping("/saveConsumer")
    public Result saveConsumer(@RequestBody Consumer consumer){
        try {
            System.out.println(consumer);
            consumerservice.saveConsumer(consumer);
            return  Result.success().addmessage("msg","添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail().addmessage("msg","添加失败");
        }
    }
}
