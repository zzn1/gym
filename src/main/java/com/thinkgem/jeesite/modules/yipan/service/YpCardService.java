/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.dao.YpCardDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 卡种管理Service
 *
 * @author zcx
 * @version 2020-05-05
 */
@Service
@Transactional(readOnly = true)
public class YpCardService extends CrudService<YpCardDao, YpCard> {

    public YpCard get(String id) {
        return super.get(id);
    }

    public List<YpCard> findList(YpCard ypCard) {
        return super.findList(ypCard);
    }

    public Page<YpCard> findPage(Page<YpCard> page, YpCard ypCard) {
        return super.findPage(page, ypCard);
    }

    @Transactional(readOnly = false)
    public void save(YpCard ypCard) {
        super.save(ypCard);
    }

    @Transactional(readOnly = false)
    public void delete(YpCard ypCard) {
        super.delete(ypCard);
    }

}
