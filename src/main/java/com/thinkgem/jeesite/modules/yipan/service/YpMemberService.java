/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.dao.YpMemberDao;
import com.thinkgem.jeesite.modules.yipan.dto.ResponseResult;
import com.thinkgem.jeesite.modules.yipan.entity.YpMember;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会员管理Service
 *
 * @author zcx
 * @version 2020-05-24
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

    public ResponseResult login(YpMember ypMember) {
        YpMember member = super.get(ypMember.getOpenid());
        if (member==null){
            try {
                super.save(ypMember);
            }catch (Exception e){
                return ResponseResult.error("登录认证失败");
            }
        }
        return ResponseResult.success();
    }
}
