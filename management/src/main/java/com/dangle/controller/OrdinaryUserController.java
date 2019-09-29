package com.dangle.controller;

import com.dangle.entity.pageEntity;
import com.dangle.pojo.OrdinaryUser;
import com.dangle.service.OrdinaryUserService;
import com.dangle.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/9/24
 * 用户模块
 */
@RestController
@RequestMapping("/ordinary")
public class OrdinaryUserController {
    @Autowired
    private OrdinaryUserService service;
    @RequestMapping(value = "/findAll/{page}/{size}",method = RequestMethod.POST)
    public pageEntity<OrdinaryUser> selectedAlluser(@PathVariable Integer page, @PathVariable Integer size, @RequestBody OrdinaryUser user){
        System.out.println(user);

        return  service.selectedAlluser(page,size,user);
    }

    /**
     *
     * @param id
     * @return
     * 禁用用户
     */
    @RequestMapping("/prohibit/{id}")
    public Result prohibitUser(@PathVariable Long id){
        try {
            service.prohibitUser(id);
            return Result.success().addmessage("msg","禁用成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail().addmessage("msg","禁用失败！");
        }
    }

    /**
     * 启用员工
     * @param id
     * @return
     */
    @GetMapping("/actiivation/{id}")
    public Result actiivationUser(@PathVariable Long id){
        try {
            service.actiivationUser(id);
            return Result.success().addmessage("msg","启用成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail().addmessage("msg","启用失败！");
        }
    }

}
