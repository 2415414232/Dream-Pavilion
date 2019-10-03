package com.dangle.service.impl;

import com.dangle.Dao.staffDao;
import com.dangle.entity.pageEntity;
import com.dangle.pojo.Affair;
import com.dangle.pojo.Staff;
import com.dangle.service.staffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author by 党桢乐 on 2019/9/27
 */
@Service
public class staffServiceImpl implements staffService {
    @Autowired
    private staffDao staffdao;

    public pageEntity<Staff> findAllstaff(Integer page,Integer size,Staff staff) {
        PageHelper.startPage(page,size);
        Page<Staff> pageg=(Page<Staff>) staffdao.findAllstaff(staff);
        pageEntity<Staff> pageEntity=new pageEntity<>();
        pageEntity.setTotalpages(pageg.getPages()).setNums(pageg.getTotal()).setList(pageg.getResult());
        return pageEntity;
    }

    @Override
    public Staff findDetails(Long id) {
        return staffdao.findDetails(id);
    }

    @Override
    public Staff editStaff(Long id) {
        return staffdao.editStaff(id);
    }


    /*保存员工*/
    @Override
    public void addStaff(Staff staff) {
        staffdao.addStaff(staff);
    }

    @Override
    public void saveStaff(Staff staff) {
        staff.setStatus("1");
        staffdao.saveStaff(staff);
    }

    /**
     * 添加事务
     * @param affair
     */
    @Override
    public void addAffair(Affair affair) {
        staffdao.addAffair(affair);
    }

    @Override
    public void deleteStaff(Long[] ids) {
        Executors.newFixedThreadPool(10);
        for(Long id: ids){
            staffdao.deleteStaff(id);
            staffdao.deleteAffair(id);
        }
    }
}
