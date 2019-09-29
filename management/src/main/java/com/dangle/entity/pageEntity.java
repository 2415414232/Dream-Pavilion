package com.dangle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by 党桢乐 on 2019/9/25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class pageEntity<T> implements Serializable {
    private Long nums;//总的记录数
    private Integer totalpages;//总的页数
    private List<T> list=new ArrayList<>();
}
