/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import java.util.List;

import com.thinkgem.jeesite.modules.yipan.dto.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.entity.YpMember;
import com.thinkgem.jeesite.modules.yipan.dao.YpMemberDao;

import java.util.Date;
import java.util.List;

/**
 * 会员管理Service
 * @author zcx
 * @version 2020-05-29
 */
@Service
@Transactional(readOnly = true)
public class YpMemberService extends CrudService<YpMemberDao, YpMember> {

    public YpMember get(String id) {
        return super.get(id);
    }

    public List<YpMember> findList(YpMember ypMember) {
        return super.findList(ypMember);
    }

    public Page<YpMember> findPage(Page<YpMember> page, YpMember ypMember) {
        return super.findPage(page, ypMember);
    }

    @Transactional(readOnly = false)
    public void save(YpMember ypMember) {
        super.save(ypMember);
    }

    @Transactional(readOnly = false)
    public void delete(YpMember ypMember) {
        super.delete(ypMember);
    }

    @Transactional(readOnly = false)
    public ResponseResult saveYpMember(YpMember ypMember) {
        YpMember yp = new YpMember();
        yp.setOpenid(ypMember.getOpenid());
        List<YpMember> member = super.findList(yp);
        if (member.size()==0){
            try {
                super.save(ypMember);
            }catch (Exception e){
                return ResponseResult.error("登录认证失败:"+e.getMessage());
            }
        }
        return ResponseResult.success();
    }


}