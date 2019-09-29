package com.dangle.controller;

import com.dangle.entity.Result;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Affair;
import com.dangle.pojo.Staff;
import com.dangle.service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/9/27
 */
@RestController
@RequestMapping("/staff")
public class staffController {
    @Autowired
    private staffService  staffservice;
    @RequestMapping(value = "/findstaff/{page}/{size}",method = RequestMethod.POST)
    public pageEntity<Staff> findAllstaff(@PathVariable Integer page,@PathVariable Integer size,@RequestBody Staff staff){

        /*for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"========="+entry.getValue());
        }*/
        return  staffservice.findAllstaff(page,size,staff);
    }
    @RequestMapping("/findDetails/{id}")
    public Staff findDetails(@PathVariable Long id){
        return staffservice.findDetails(id);
    }
    @RequestMapping("/editStaff/{id}")
    public Staff editStaff(@PathVariable Long id){
        return staffservice.editStaff(id);
    }
    @RequestMapping("/addStaff")
            public Result addStaff(@RequestBody Staff staff){
                try {

                    staffservice.addStaff(staff);
                    return Result.success().addmessage("msg","修改成功");
                }catch (Exception e){
                    e.printStackTrace();
                    return Result.fail().addmessage("msg","修改失败");

        }
    }
    @RequestMapping("/saveStaff")
            public Result saveStaff(@RequestBody Staff staff){
                try {

                    staffservice.saveStaff(staff);
                    return Result.success().addmessage("msg","添加成功");
                }catch (Exception e){
                    e.printStackTrace();
                    return Result.fail().addmessage("msg","添加失败");

        }
    }
    /*添加事务*/
    @RequestMapping("/addAffair")
            public Result addAffair(@RequestBody Affair affair){
                try {
                    staffservice.addAffair(affair);
                    return Result.success().addmessage("msg","添加成功");
                }catch (Exception e){
                    e.printStackTrace();
                    return Result.fail().addmessage("msg","添加失败");

        }
    }

}
