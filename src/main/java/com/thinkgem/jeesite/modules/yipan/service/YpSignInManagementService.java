/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.entity.YpSignInManagement;
import com.thinkgem.jeesite.modules.yipan.dao.YpSignInManagementDao;

/**
 * 打卡记录Service
 * @author zcx
 * @version 2020-05-24
 */
@Service
@Transactional(readOnly = true)
public class YpSignInManagementService extends CrudService<YpSignInManagementDao, YpSignInManagement> {

	public YpSignInManagement get(String id) {
		return super.get(id);
	}
	
	public List<YpSignInManagement> findList(YpSignInManagement ypSignInManagement) {
		return super.findList(ypSignInManagement);
	}
	
	public Page<YpSignInManagement> findPage(Page<YpSignInManagement> page, YpSignInManagement ypSignInManagement) {
		return super.findPage(page, ypSignInManagement);
	}
	
	@Transactional(readOnly = false)
	public void save(YpSignInManagement ypSignInManagement) {
		super.save(ypSignInManagement);
	}
	
	@Transactional(readOnly = false)
	public void delete(YpSignInManagement ypSignInManagement) {
		super.delete(ypSignInManagement);
	}
	
}