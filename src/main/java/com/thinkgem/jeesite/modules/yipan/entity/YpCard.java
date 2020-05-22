/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 卡种管理Entity
 * @author zcx
 * @version 2020-05-05
 */
public class YpCard extends DataEntity<YpCard> {
	
	private static final long serialVersionUID = 1L;
	private String cardnum;		// 卡号
	private String cardtype;		// 卡类型
	private String cardname;		// 卡名称
	private String stored;		// 储值金额
	private String fretype;		// 次卡类型
	private String region;		// 地区
	
	public YpCard() {
		super();
	}

	public YpCard(String id){
		super(id);
	}

	@Length(min=0, max=255, message="卡号长度必须介于 0 和 255 之间")
	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	
	@Length(min=0, max=255, message="卡类型长度必须介于 0 和 255 之间")
	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	@Length(min=0, max=255, message="卡名称长度必须介于 0 和 255 之间")
	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	
	@Length(min=0, max=255, message="储值金额长度必须介于 0 和 255 之间")
	public String getStored() {
		return stored;
	}

	public void setStored(String stored) {
		this.stored = stored;
	}
	
	@Length(min=0, max=255, message="次卡类型长度必须介于 0 和 255 之间")
	public String getFretype() {
		return fretype;
	}

	public void setFretype(String fretype) {
		this.fretype = fretype;
	}
	
	@Length(min=0, max=255, message="地区长度必须介于 0 和 255 之间")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
}