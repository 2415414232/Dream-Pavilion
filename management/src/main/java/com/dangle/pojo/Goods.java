package com.dangle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author by 党桢乐 on 2020/5/13
 * 商品表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Goods implements Serializable {
    private  Integer  serviceid;
    private String  servicename;
    private  Float  money;
    private   Integer num;
}
