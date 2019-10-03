package com.dangle.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author by 党桢乐 on 2019/9/30
 * 顾客实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Consumer implements Serializable {
    private Long id;
    private String conname;
    private String conphone;
    private String consex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy/MM/dd")
    private Date  contime;
    private String conservice;
    private String conaccount;
    private String constatus;
    private  String endtime;
}
