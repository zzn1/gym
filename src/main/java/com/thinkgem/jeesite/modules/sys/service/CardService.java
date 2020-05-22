/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.Card;
import com.thinkgem.jeesite.modules.sys.dao.CardDao;

/**
 * 卡种表方案Service
 * @author zcx
 * @version 2020-05-05
 */
@Service
@Transactional(readOnly = true)
public class CardService extends CrudService<CardDao, Card> {

	public Card get(String id) {
		return super.get(id);
	}
	
	public List<Card> findList(Card card) {
		return super.findList(card);
	}
	
	public Page<Card> findPage(Page<Card> page, Card card) {
		return super.findPage(page, card);
	}
	
	@Transactional(readOnly = false)
	public void save(Card card) {
		super.save(card);
	}
	
	@Transactional(readOnly = false)
	public void delete(Card card) {
		super.delete(card);
	}
	
}