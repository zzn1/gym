/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.dao.YpCardtypeDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpCardtype;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 卡种表方案Service
 *
 * @author zcx
 * @version 2020-05-24
 */
@Service
@Transactional(readOnly = true)
public class YpCardtypeService extends CrudService<YpCardtypeDao, YpCardtype> {

    public YpCardtype get(String id) {
        return super.get(id);
    }

    public List<YpCardtype> findList(YpCardtype ypCardtype) {
        return super.findList(ypCardtype);
    }

    public Page<YpCardtype> findPage(Page<YpCardtype> page, YpCardtype ypCardtype) {
        return super.findPage(page, ypCardtype);
    }

    @Transactional(readOnly = false)
    public void save(YpCardtype ypCardtype) {
        super.save(ypCardtype);
    }

    @Transactional(readOnly = false)
    public void delete(YpCardtype ypCardtype) {
        super.delete(ypCardtype);
    }

}
