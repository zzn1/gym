/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.dao.YpCardHolderDao;
import com.thinkgem.jeesite.modules.yipan.dto.DropDownResult;
import com.thinkgem.jeesite.modules.yipan.entity.YpCardHolder;
import com.thinkgem.jeesite.modules.yipan.entity.YpRockHall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 持卡信息Service
 *
 * @author zcx
 * @version 2020-05-24
 */
@Service
@Transactional(readOnly = true)
public class YpCardHolderService extends CrudService<YpCardHolderDao, YpCardHolder> {

    public YpCardHolder get(String id) {
        return super.get(id);
    }

    public List<YpCardHolder> findList(YpCardHolder ypCardHolder) {
        return super.findList(ypCardHolder);
    }

    public  List<DropDownResult> getDropDownResults(YpCardHolder cardHolder){
        List<YpCardHolder> ypCardHolders = this.findList(cardHolder);
        List<DropDownResult> dropDownResults = new ArrayList<DropDownResult>();
        if(ypCardHolders.size()>0){
            DropDownResult dropDownResult = new DropDownResult();
            for (YpCardHolder  ypCardHolder : ypCardHolders){
                dropDownResult.setId(ypCardHolder.getCardNo());
                dropDownResult.setText(ypCardHolder.getCardType());
                dropDownResults.add(dropDownResult);
            }
        }
        return dropDownResults;
    }

    public Page<YpCardHolder> findPage(Page<YpCardHolder> page, YpCardHolder ypCardHolder) {
        return super.findPage(page, ypCardHolder);
    }

    @Transactional(readOnly = false)
    public void save(YpCardHolder ypCardHolder) {
        super.save(ypCardHolder);
    }

    @Transactional(readOnly = false)
    public void delete(YpCardHolder ypCardHolder) {
        super.delete(ypCardHolder);
    }

    /**
     * 通过会员卡编号查询卡信息
     *
     * @param cardNo
     * @return
     */
    public YpCardHolder findByCardNo(String cardNo) {
        return dao.findByCardNo(cardNo);
    }
}
