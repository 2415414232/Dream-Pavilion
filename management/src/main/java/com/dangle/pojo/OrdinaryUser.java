package com.dangle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author by 党桢乐 on 2019/9/23
 * 普通用户实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdinaryUser implements Serializable {
    private Long id; //主键
    private  String name;
    private String phone;
    private String sex;
    private  String address;
    private  Integer status;

}
