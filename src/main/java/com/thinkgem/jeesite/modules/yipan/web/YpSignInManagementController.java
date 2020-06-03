/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.yipan.dto.ServiceResult;
import com.thinkgem.jeesite.modules.yipan.dto.YpSignInManagementDTO;
import com.thinkgem.jeesite.modules.yipan.entity.YpSignInManagement;
import com.thinkgem.jeesite.modules.yipan.service.YpSignInManagementService;
import com.thinkgem.jeesite.modules.yipan.util.EntityDtoUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 打卡记录Controller
 *
 * @author zcx
 * @version 2020-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/yipan/ypSignInManagement")
public class YpSignInManagementController extends BaseController {

    @Autowired
    private YpSignInManagementService ypSignInManagementService;

    @ModelAttribute
    public YpSignInManagement get(@RequestParam(required = false) String id) {
        YpSignInManagement entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = ypSignInManagementService.get(id);
        }
        if (entity == null) {
            entity = new YpSignInManagement();
        }
        return entity;
    }

    @RequiresPermissions("yipan:ypSignInManagement:view")
    @RequestMapping(value = {"list", ""})
    public String list(YpSignInManagement ypSignInManagement, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<YpSignInManagement> page = ypSignInManagementService.findPage(new Page<YpSignInManagement>(request, response), ypSignInManagement);
        model.addAttribute("page", page);
        return "modules/yipan/ypSignInManagementList";
    }

    @RequiresPermissions("yipan:ypSignInManagement:view")
    @RequestMapping(value = "form")
    public String form(YpSignInManagement ypSignInManagement, Model model) {
        model.addAttribute("ypSignInManagement", ypSignInManagement);
        return "modules/yipan/ypSignInManagementForm";
    }

    /**
     * 根据openId获取打卡记录
     *
     * @param openId
     * @param
     * @return
     */
    @RequestMapping(value = {"list/{openId}"})
    @ResponseBody
    public List<YpSignInManagementDTO> listByopenId(@PathVariable("openId") String openId, YpSignInManagement ypSignInManagement) {
        ypSignInManagement.setOpenid(openId);
        return EntityDtoUtil.entityTODtoList(ypSignInManagementService.findList(ypSignInManagement),new ArrayList<YpSignInManagementDTO>(),YpSignInManagementDTO.class);
    }

    @RequiresPermissions("yipan:ypSignInManagement:edit")
    @RequestMapping(value = "save")
    public String save(YpSignInManagement ypSignInManagement, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, ypSignInManagement)) {
            return form(ypSignInManagement, model);
        }
        ypSignInManagementService.save(ypSignInManagement);
        addMessage(redirectAttributes, "保存打卡记录成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypSignInManagement/?repage";
    }

    @RequiresPermissions("yipan:ypSignInManagement:edit")
    @RequestMapping(value = "delete")
    public String delete(YpSignInManagement ypSignInManagement, RedirectAttributes redirectAttributes) {
        ypSignInManagementService.delete(ypSignInManagement);
        addMessage(redirectAttributes, "删除打卡记录成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypSignInManagement/?repage";
    }

    @RequestMapping(value = "debit/{openId}/{cardNo}/{rockNo}")
    @ResponseBody
    public ServiceResult debit(@PathVariable("openId") String openId, @PathVariable("cardNo") String cardNo, @PathVariable("rockNo") String rockNo) {
        return ypSignInManagementService.debit(openId, cardNo, rockNo);
    }

}
