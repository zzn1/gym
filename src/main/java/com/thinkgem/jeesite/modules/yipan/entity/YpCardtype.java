/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 卡种表方案Entity
 * @author zcx
 * @version 2020-05-24
 */
public class YpCardtype extends DataEntity<YpCardtype> {
	
	private static final long serialVersionUID = 1L;
	private String area;		// 地区
	private String cardtype;		// 卡种
	private String sstored;		// 储值金额
	private String term;		// 期限
	private String equity;		// 权益
	private String creatBy;		// 创建者
	
	public YpCardtype() {
		super();
	}

	public YpCardtype(String id){
		super(id);
	}

	@Length(min=0, max=255, message="地区长度必须介于 0 和 255 之间")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=255, message="卡种长度必须介于 0 和 255 之间")
	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	@Length(min=0, max=255, message="储值金额长度必须介于 0 和 255 之间")
	public String getSstored() {
		return sstored;
	}

	public void setSstored(String sstored) {
		this.sstored = sstored;
	}
	
	@Length(min=0, max=255, message="期限长度必须介于 0 和 255 之间")
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	@Length(min=0, max=255, message="权益长度必须介于 0 和 255 之间")
	public String getEquity() {
		return equity;
	}

	public void setEquity(String equity) {
		this.equity = equity;
	}
	
	@Length(min=0, max=64, message="创建者长度必须介于 0 和 64 之间")
	public String getCreatBy() {
		return creatBy;
	}

	public void setCreatBy(String creatBy) {
		this.creatBy = creatBy;
	}
	
}