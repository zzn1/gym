/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.yipan.entity.YpCardtype;
import com.thinkgem.jeesite.modules.yipan.service.YpCardtypeService;
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
 * 卡种表方案Controller
 *
 * @author zcx
 * @version 2020-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/yipan/ypCardtype")
public class YpCardtypeController extends BaseController {

    @Autowired
    private YpCardtypeService ypCardtypeService;

    @ModelAttribute
    public YpCardtype get(@RequestParam(required = false) String id) {
        YpCardtype entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = ypCardtypeService.get(id);
        }
        if (entity == null) {
            entity = new YpCardtype();
        }
        return entity;
    }

    @RequiresPermissions("yipan:ypCardtype:view")
    @RequestMapping(value = {"list", ""})
    public String list(YpCardtype ypCardtype, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<YpCardtype> page = ypCardtypeService.findPage(new Page<YpCardtype>(request, response), ypCardtype);
        model.addAttribute("page", page);
        return "modules/yipan/ypCardtypeList";
    }

    @RequiresPermissions("yipan:ypCardtype:view")
    @RequestMapping(value = "form")
    public String form(YpCardtype ypCardtype, Model model) {
        model.addAttribute("ypCardtype", ypCardtype);
        return "modules/yipan/ypCardtypeForm";
    }

    @RequiresPermissions("yipan:ypCardtype:edit")
    @RequestMapping(value = "save")
    public String save(YpCardtype ypCardtype, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, ypCardtype)) {
            return form(ypCardtype, model);
        }
        ypCardtypeService.save(ypCardtype);
        addMessage(redirectAttributes, "保存卡种表方案成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypCardtype/?repage";
    }

    @RequiresPermissions("yipan:ypCardtype:edit")
    @RequestMapping(value = "delete")
    public String delete(YpCardtype ypCardtype, RedirectAttributes redirectAttributes) {
        ypCardtypeService.delete(ypCardtype);
        addMessage(redirectAttributes, "删除卡种表方案成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypCardtype/?repage";
    }

}
