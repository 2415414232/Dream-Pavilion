package com.dangle.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by 党桢乐 on 2020/5/13
 */
public class Time {
    public  static String getTime(){
        SimpleDateFormat aa=new SimpleDateFormat("yyyy-MM-dd");
        return aa.format(new Date());
    }
}
