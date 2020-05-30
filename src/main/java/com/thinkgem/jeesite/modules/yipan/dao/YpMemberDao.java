/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.yipan.entity.YpMember;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 会员管理DAO接口
 *
 * @author zcx
 * @version 2020-05-30
 */
@MyBatisDao
public interface YpMemberDao extends CrudDao<YpMember> {
    @Select("select * from yp_member where openid = #{openId}")
    YpMember findByOpenId(String openId);

    @Update("update yp_member set beans = beans + #{beans} where openid = #{openId}")
    void updateBeansByOpenId(@Param("beans") long beans, @Param("openId") String openId);
}
