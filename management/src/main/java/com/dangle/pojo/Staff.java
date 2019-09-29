package com.dangle.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author by 党桢乐 on 2019/9/27
 * 员工实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Staff implements Serializable {
    private Long id;
    private String name;
    private String telephone;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //写入数据库
    @JSONField(format = "yyyy/MM/dd") //导向页面
    private Date entrytime;
    private  String familyaddress;
    private  String status;
    private  String idNumber;
    private List<Affair> list;
}
