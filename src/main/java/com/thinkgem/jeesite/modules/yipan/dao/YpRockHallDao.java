/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpRockHall;
import org.apache.ibatis.annotations.Select;

/**
 * 岩馆管理DAO接口
 *
 * @author zcx
 * @version 2020-05-27
 */
@MyBatisDao
public interface YpRockHallDao extends CrudDao<YpRockHall> {

    @Select("select * from yp_rock_hall where rock_no = #{rockNo}")
    YpRockHall findByRockNo(String rockNo);
}
