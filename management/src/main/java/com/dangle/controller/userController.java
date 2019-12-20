package com.dangle.controller;

import com.dangle.entity.Result;
import com.dangle.pojo.User;
import com.dangle.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by 党桢乐 on 2019/12/20
 * 用户添加
 */
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
       try {

           userService.addUser(user);
       }catch (Exception e){
           return  Result.success().addmessage("msg","添加失败！");
       }
        return  Result.success().addmessage("msg","添加成功！");
    }
}
