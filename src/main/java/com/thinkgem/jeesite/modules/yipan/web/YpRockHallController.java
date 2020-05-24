/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yipan.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.yipan.entity.YpRockHall;
import com.thinkgem.jeesite.modules.yipan.service.YpRockHallService;

/**
 * 岩馆管理Controller
 * @author zcx
 * @version 2020-05-24
 */
@Controller
@RequestMapping(value = "${adminPath}/ypRockHall")
public class YpRockHallController extends BaseController {

	@Autowired
	private YpRockHallService ypRockHallService;

	@ModelAttribute
	public YpRockHall get(@RequestParam(required=false) String id) {
		YpRockHall entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ypRockHallService.get(id);
		}
		if (entity == null){
			entity = new YpRockHall();
		}
		return entity;
	}

	@RequiresPermissions("yipan:ypRockHall:view")
	@RequestMapping(value = {"list", ""})
	public String list(YpRockHall ypRockHall, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YpRockHall> page = ypRockHallService.findPage(new Page<YpRockHall>(request, response), ypRockHall);
		model.addAttribute("page", page);
		return "modules/yipan/ypRockHallList";
	}

	@RequiresPermissions("yipan:ypRockHall:view")
	@RequestMapping(value = "form")
	public String form(YpRockHall ypRockHall, Model model) {
		model.addAttribute("ypRockHall", ypRockHall);
		return "modules/yipan/ypRockHallForm";
	}

	@RequiresPermissions("yipan:ypRockHall:edit")
	@RequestMapping(value = "save")
	public String save(YpRockHall ypRockHall, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ypRockHall)){
			return form(ypRockHall, model);
		}
		ypRockHallService.save(ypRockHall);
		addMessage(redirectAttributes, "保存岩馆管理成功");
		return "redirect:"+Global.getAdminPath()+"/yipan/ypRockHall/?repage";
	}

	@RequiresPermissions("yipan:ypRockHall:edit")
	@RequestMapping(value = "delete")
	public String delete(YpRockHall ypRockHall, RedirectAttributes redirectAttributes) {
		ypRockHallService.delete(ypRockHall);
		addMessage(redirectAttributes, "删除岩馆管理成功");
		return "redirect:"+Global.getAdminPath()+"/yipan/ypRockHall/?repage";
	}

}
