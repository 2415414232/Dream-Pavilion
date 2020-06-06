package com.dangle.controller;

import com.dangle.entity.Result;
import com.dangle.entity.Time;
import com.dangle.pojo.Goods;
import com.dangle.service.goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by 党桢乐 on 2020/5/13
 */
@RestController
@RequestMapping("/goods")
public class goodsController {
    @Autowired
    private goodsService  goodsService;
    @RequestMapping("/saveGoods")
    public Result saveGoods(@RequestBody Goods goods){
       try{

           goodsService.saveGoods(goods);
       }catch (Exception e){
           e.printStackTrace();
           return  Result.fail().addmessage("msg","添加失败");
       }
        return  Result.fail().addmessage("msg","添加成功");
    }
    @RequestMapping("/deleteGoods/{id}")
    public Result deleteGoods(@PathVariable Integer id){
        goodsService.deleteGoods(id);
        return Result.success().addmessage("msg","删除成功");
    }
    @RequestMapping("/findGoodsById/{id}")
    public Result findGoodsById(@PathVariable Integer id){

        return Result.success().addmessage("msg",goodsService.findGoodsById(id));
    }
    @RequestMapping("/updateGoods")
    public Result updateGoods(@RequestBody Goods goods){
        goodsService.updateGoods(goods);
        return Result.success().addmessage("msg","修改成功");
    }
    @RequestMapping("/findordernum")
    public Result findordernum() throws Exception {

        return Result.success().addmessage("msg",goodsService.findordernum());
    }

}
