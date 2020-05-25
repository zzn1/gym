/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.yipan.entity.YpBill;
import com.thinkgem.jeesite.modules.yipan.service.YpBillService;
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
 * 流水记账Controller
 *
 * @author zcx
 * @version 2020-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/yipan//ypBill")
public class YpBillController extends BaseController {

    @Autowired
    private YpBillService ypBillService;

    @ModelAttribute
    public YpBill get(@RequestParam(required = false) String id) {
        YpBill entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = ypBillService.get(id);
        }
        if (entity == null) {
            entity = new YpBill();
        }
        return entity;
    }

    @RequiresPermissions("yipan:ypBill:view")
    @RequestMapping(value = {"list", ""})
    public String list(YpBill ypBill, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<YpBill> page = ypBillService.findPage(new Page<YpBill>(request, response), ypBill);
        model.addAttribute("page", page);
        return "modules/yipan/ypBillList";
    }

    @RequiresPermissions("yipan:ypBill:view")
    @RequestMapping(value = "form")
    public String form(YpBill ypBill, Model model) {
        model.addAttribute("ypBill", ypBill);
        return "modules/yipan/ypBillForm";
    }

    @RequiresPermissions("yipan:ypBill:edit")
    @RequestMapping(value = "save")
    public String save(YpBill ypBill, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, ypBill)) {
            return form(ypBill, model);
        }
        ypBillService.save(ypBill);
        addMessage(redirectAttributes, "保存流水记账成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypBill/?repage";
    }

    @RequiresPermissions("yipan:ypBill:edit")
    @RequestMapping(value = "delete")
    public String delete(YpBill ypBill, RedirectAttributes redirectAttributes) {
        ypBillService.delete(ypBill);
        addMessage(redirectAttributes, "删除流水记账成功");
        return "redirect:" + Global.getAdminPath() + "/yipan/ypBill/?repage";
    }

}
