/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

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
import com.thinkgem.jeesite.modules.sys.entity.RockHall;
import com.thinkgem.jeesite.modules.sys.service.RockHallService;

/**
 * 岩馆管理Controller
 * @author zcx
 * @version 2020-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/rockHall")
public class RockHallController extends BaseController {

	@Autowired
	private RockHallService rockHallService;
	
	@ModelAttribute
	public RockHall get(@RequestParam(required=false) String id) {
		RockHall entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = rockHallService.get(id);
		}
		if (entity == null){
			entity = new RockHall();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:rockHall:view")
	@RequestMapping(value = {"list", ""})
	public String list(RockHall rockHall, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RockHall> page = rockHallService.findPage(new Page<RockHall>(request, response), rockHall); 
		model.addAttribute("page", page);
		return "modules/sys/rockHallList";
	}

	@RequiresPermissions("sys:rockHall:view")
	@RequestMapping(value = "form")
	public String form(RockHall rockHall, Model model) {
		model.addAttribute("rockHall", rockHall);
		return "modules/sys/rockHallForm";
	}

	@RequiresPermissions("sys:rockHall:edit")
	@RequestMapping(value = "save")
	public String save(RockHall rockHall, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, rockHall)){
			return form(rockHall, model);
		}
		rockHallService.save(rockHall);
		addMessage(redirectAttributes, "保存岩馆管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/rockHall/?repage";
	}
	
	@RequiresPermissions("sys:rockHall:edit")
	@RequestMapping(value = "delete")
	public String delete(RockHall rockHall, RedirectAttributes redirectAttributes) {
		rockHallService.delete(rockHall);
		addMessage(redirectAttributes, "删除岩馆管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/rockHall/?repage";
	}

}