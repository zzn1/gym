/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.entity.YpRockHall;
import com.thinkgem.jeesite.modules.yipan.dao.YpRockHallDao;

/**
 * 岩馆管理Service
 * @author zcx
 * @version 2020-05-24
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
	
}