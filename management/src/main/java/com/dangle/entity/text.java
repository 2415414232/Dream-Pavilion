package com.dangle.entity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by 党桢乐 on 2020/5/13
 */
public class text {
    public static void main(String[] args) {
        DecimalFormat aa=new DecimalFormat("0.00");
        System.out.println(aa.format((float)10/3));
    }
}
