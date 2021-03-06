/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.dao.YpRockHallDao;
import com.thinkgem.jeesite.modules.yipan.dto.DropDownResult;
import com.thinkgem.jeesite.modules.yipan.entity.YpRockHall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 岩馆管理Service
 *
 * @author zcx
 * @version 2020-05-27
 */
@Service
@Transactional(readOnly = true)
public class YpRockHallService extends CrudService<YpRockHallDao, YpRockHall> {

    public YpRockHall get(String id) {
        return super.get(id);
    }

    public List<YpRockHall> findList(YpRockHall ypRockHall) {
        return super.findList(ypRockHall);
    }

    public  List<DropDownResult> ypRockHallToDropDownResult(YpRockHall rockHall){
        List<YpRockHall> ypRockHalls = this.findList(rockHall);
        List<DropDownResult> dropDownResults = new ArrayList<DropDownResult>();
        if(ypRockHalls.size()>0){
            DropDownResult dropDownResult = new DropDownResult();
            for (YpRockHall  ypRockHall : ypRockHalls){
                dropDownResult.setId(ypRockHall.getRockNo());
                dropDownResult.setText(ypRockHall.getRockName());
                dropDownResults.add(dropDownResult);
            }
        }
        return dropDownResults;
    }

    public Page<YpRockHall> findPage(Page<YpRockHall> page, YpRockHall ypRockHall) {
        return super.findPage(page, ypRockHall);
    }

    @Transactional(readOnly = false)
    public void save(YpRockHall ypRockHall) {
        super.save(ypRockHall);
    }

    @Transactional(readOnly = false)
    public void delete(YpRockHall ypRockHall) {
        super.delete(ypRockHall);
    }

    /**
     * 通过岩馆编号查询岩馆信息
     *
     * @param rockNo
     * @return
     */
    public YpRockHall findByRockNo(String rockNo) {
        return dao.findByRockNo(rockNo);
    }
}
