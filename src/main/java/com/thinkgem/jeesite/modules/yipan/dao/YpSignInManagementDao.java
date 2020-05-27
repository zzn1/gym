/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpSignInManagement;

/**
 * 打卡记录DAO接口
 *
 * @author zcx
 * @version 2020-05-24
 */
@MyBatisDao
public interface YpSignInManagementDao extends CrudDao<YpSignInManagement> {

}
