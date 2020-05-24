/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.entity.YpBill;
import com.thinkgem.jeesite.modules.yipan.dao.YpBillDao;

/**
 * 流水记账Service
 * @author zcx
 * @version 2020-05-24
 */
@Service
@Transactional(readOnly = true)
public class YpBillService extends CrudService<YpBillDao, YpBill> {

	public YpBill get(String id) {
		return super.get(id);
	}
	
	public List<YpBill> findList(YpBill ypBill) {
		return super.findList(ypBill);
	}
	
	public Page<YpBill> findPage(Page<YpBill> page, YpBill ypBill) {
		return super.findPage(page, ypBill);
	}
	
	@Transactional(readOnly = false)
	public void save(YpBill ypBill) {
		super.save(ypBill);
	}
	
	@Transactional(readOnly = false)
	public void delete(YpBill ypBill) {
		super.delete(ypBill);
	}
	
}