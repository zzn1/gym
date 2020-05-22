/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.RockHall;
import com.thinkgem.jeesite.modules.sys.dao.RockHallDao;

/**
 * 岩馆管理Service
 * @author zcx
 * @version 2020-05-05
 */
@Service
@Transactional(readOnly = true)
public class RockHallService extends CrudService<RockHallDao, RockHall> {

	public RockHall get(String id) {
		return super.get(id);
	}
	
	public List<RockHall> findList(RockHall rockHall) {
		return super.findList(rockHall);
	}
	
	public Page<RockHall> findPage(Page<RockHall> page, RockHall rockHall) {
		return super.findPage(page, rockHall);
	}
	
	@Transactional(readOnly = false)
	public void save(RockHall rockHall) {
		super.save(rockHall);
	}
	
	@Transactional(readOnly = false)
	public void delete(RockHall rockHall) {
		super.delete(rockHall);
	}
	
}