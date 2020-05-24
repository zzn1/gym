/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.yipan.entity.YpMember;
import com.thinkgem.jeesite.modules.yipan.service.YpMemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会员管理Controller
 *
 * @author zcx
 * @version 2020-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/ypMember")
public class YpMemberController extends BaseController {

    @Autowired
    private YpMemberService ypMemberService;

    @ModelAttribute
    public YpMember get(@RequestParam(required = false) String id) {
        YpMember entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = ypMemberService.get(id);
        }
        if (entity == null) {
            entity = new YpMember();
        }
        return entity;
    }

    @RequiresPermissions("yipan:ypMember:view")
    @RequestMapping(value = {"list", ""})
    public String list(YpMember ypMember, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<YpMember> page = ypMemberService.findPage(new Page<YpMember>(request, response), ypMember);
        model.addAttribute("page", page);
        return "modules/yipan/ypMemberList";
    }

    @RequiresPermissions("yipan:ypMember:view")
    @RequestMapping(value = "form")
    public String form(YpMember ypMember, Model model) {
        model.addAttribute("ypMember", ypMember);
        return "modules/yipan/ypMemberForm";
    }

    @RequiresPermissions("yipan:ypMember:edit")
    @RequestMapping(value = "save")
    public String save(YpMember ypMember, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, ypMember)) {
            return form(ypMember, model);
        }
        ypMemberService.save(ypMember);
        addMessage(redirectAttributes, "保存会员管理成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypMember/?repage";
    }

    @RequiresPermissions("yipan:ypMember:edit")
    @RequestMapping(value = "delete")
    public String delete(YpMember ypMember, RedirectAttributes redirectAttributes) {
        ypMemberService.delete(ypMember);
        addMessage(redirectAttributes, "删除会员管理成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypMember/?repage";
    }

}
