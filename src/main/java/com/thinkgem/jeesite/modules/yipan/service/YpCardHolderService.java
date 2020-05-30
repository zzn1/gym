/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.entity.YpCardHolder;
import com.thinkgem.jeesite.modules.yipan.dao.YpCardHolderDao;

/**
 * 持卡信息Service
 * @author zcx
 * @version 2020-05-30
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
	
}