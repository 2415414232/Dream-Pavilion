package com.dangle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author by 党桢乐 on 2019/9/27
 * 事务表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Affair implements Serializable {
    private Date time;
    private String thing;
    private  Long sellerid;

}
