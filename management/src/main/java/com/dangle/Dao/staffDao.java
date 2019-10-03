package com.dangle.Dao;

import com.dangle.entity.pageEntity;
import com.dangle.pojo.Affair;
import com.dangle.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author by 党桢乐 on 2019/9/27
 */
@Mapper
@Component("staffDao")
public interface staffDao {
    List<Staff> findAllstaff(Staff staff);

    Staff findDetails(Long id);

    Staff editStaff(Long id);

    void addStaff(Staff staff);

    void saveStaff(Staff staff);

    void addAffair(Affair affair);

    void deleteStaff(Long id);

    void deleteAffair(Long id);
}
