package com.dangle.controller;

import com.dangle.entity.Result;
import com.dangle.pojo.User;
import com.dangle.service.userService;
import com.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/12/20
 * 用户添加
 */
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
       try {

           userService.addUser(user);
       }catch (Exception e){
           return  Result.fail().addmessage("msg","添加失败！");
       }
        return  Result.success().addmessage("msg","添加成功！");
    }
    @RequestMapping("/login")
    public  Result login(@RequestBody User user, HttpServletRequest request){
        User us = userService.login(user);
        if(us!=null){

            String role=userService.getRole(us.getRid());

            String tocken = jwtUtil.createJWT(String.valueOf(us.getUid()), us.getUname(), role);
            return  Result.success().addmessage("msg","登陆成功！").addmessage("name",us.getUsername()).addmessage("tocken",tocken);

        }else{

            return Result.fail().addmessage("msg","账号或密码错误！");
        }
    }
    @RequestMapping("/index")
       public Result index(HttpServletRequest request, HttpServletResponse response,@RequestBody Map name){

           request.getSession().setAttribute("name",name.get("name"));
           return Result.success();
    }

    /**
     * 查找用户名
     * @param request
     * @return
     */
    @RequestMapping(value = "/findName",method = RequestMethod.GET)
    public  Result findName(HttpServletRequest request){
        String name=null;
        try {
            name=(String) request.getSession().getAttribute("name");
            System.out.println(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.success().addmessage("name",name);
    }
    /**
     * 注销
     */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request){
        request.getSession().removeAttribute("name");
    }
    /**
     * 查找后台用户
     */
    @RequestMapping("/findUser")
    public  Result findUser(){

        return  Result.success().addmessage("list",userService.findUser());
    }
    @RequestMapping("/deleteUser/{uid}")
    public  void deleteUser(@PathVariable Integer uid){
        userService.deleteUser(uid);
    }

}
