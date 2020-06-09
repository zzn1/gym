/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.modules.yipan.dto.ResponseResult;
import com.thinkgem.jeesite.modules.yipan.util.UrlUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yipan.entity.YpMember;
import com.thinkgem.jeesite.modules.yipan.dao.YpMemberDao;


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
        JSONObject jsonObject = UrlUtil.getSessionKeyOrOpenId(ypMember.getOpenid());
        String openId = jsonObject.getString("openid");
        //暂未用到,后续调整
       // String sessionKey = jsonObject.getString("session_key");
        YpMember yp = new YpMember();
        yp.setOpenid(openId);
        List<YpMember> member = super.findList(yp);
        String beans = "0";
        if (member.size()==0){
            try {
                ypMember.setOpenid(openId);
                super.save(ypMember);
            }catch (Exception e){
                return ResponseResult.error("登录认证失败:"+e.getMessage());
            }
        }else {
            beans = member.get(0).getBeans()+"";
        }
        return ResponseResult.success(openId,beans);
    }

    public YpMember findByOpenId(String openId) {
        return dao.findByOpenId(openId);
    }

    public void updateBeansByOpenId(String openId, long beans) {
        dao.updateBeansByOpenId(beans, openId);
    }










}
