package com.dangle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by 党桢乐 on 2019/9/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private boolean res;
    private  Map<String,String> map=new HashMap<>();
    public static  Result success(){
        Result result=new Result();
        result.setRes(true);
        return result;
    }
    public static Result fail(){
        Result result=new Result();
        result.setRes(false);
        return result;
    }
    public  Result addmessage(String key,String value){
        this.getMap().put(key,value);
                return this;
    }

}
