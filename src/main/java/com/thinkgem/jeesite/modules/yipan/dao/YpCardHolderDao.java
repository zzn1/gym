/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpCardHolder;

/**
 * 持卡信息DAO接口
 *
 * @author zcx
 * @version 2020-05-24
 */
@MyBatisDao
public interface YpCardHolderDao extends CrudDao<YpCardHolder> {

}
