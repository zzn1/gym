/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 岩馆管理Entity
 * @author zcx
 * @version 2020-05-05
 */
public class RockHall extends DataEntity<RockHall> {
	
	private static final long serialVersionUID = 1L;
	private String region;		// 地区
	private String name;		// 岩馆名称
	private String status;		// 状态
	private String type;		// 岩馆类型
	
	public RockHall() {
		super();
	}

	public RockHall(String id){
		super(id);
	}

	@Length(min=0, max=255, message="地区长度必须介于 0 和 255 之间")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	@Length(min=0, max=255, message="岩馆名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="状态长度必须介于 0 和 255 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=255, message="岩馆类型长度必须介于 0 和 255 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}