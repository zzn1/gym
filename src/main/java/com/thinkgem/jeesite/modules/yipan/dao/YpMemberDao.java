/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpMember;

/**
 * 会员管理DAO接口
 * @author zcx
 * @version 2020-05-29
 */
@MyBatisDao
public interface YpMemberDao extends CrudDao<YpMember> {
	
}