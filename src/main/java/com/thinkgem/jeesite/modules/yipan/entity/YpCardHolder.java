/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 持卡信息Entity
 * @author zcx
 * @version 2020-05-30
 */
public class YpCardHolder extends DataEntity<YpCardHolder> {
	
	private static final long serialVersionUID = 1L;
	private String cardNo;		// 卡号
	private String cardType;		// 卡类型
	private String openid;		// openid
	private String carduser;		// 持卡人姓名
	private Long remainingTimes;		// 剩余次数
	private String beans;		// 易豆
	private Date expirationDate;		// 失效日期
	private Date buyDate;		// 购卡日期
	
	public YpCardHolder() {
		super();
	}

	public YpCardHolder(String id){
		super(id);
	}

	@Length(min=0, max=255, message="卡号长度必须介于 0 和 255 之间")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	@Length(min=0, max=255, message="卡类型长度必须介于 0 和 255 之间")
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	@Length(min=0, max=255, message="openid长度必须介于 0 和 255 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=255, message="持卡人姓名长度必须介于 0 和 255 之间")
	public String getCarduser() {
		return carduser;
	}

	public void setCarduser(String carduser) {
		this.carduser = carduser;
	}
	
	public Long getRemainingTimes() {
		return remainingTimes;
	}

	public void setRemainingTimes(Long remainingTimes) {
		this.remainingTimes = remainingTimes;
	}
	
	@Length(min=0, max=255, message="易豆长度必须介于 0 和 255 之间")
	public String getBeans() {
		return beans;
	}

	public void setBeans(String beans) {
		this.beans = beans;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	
}