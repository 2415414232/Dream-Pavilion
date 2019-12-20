package com.dangle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author by 党桢乐 on 2019/12/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式存储
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String upassword;
    private  Integer rid;
}
