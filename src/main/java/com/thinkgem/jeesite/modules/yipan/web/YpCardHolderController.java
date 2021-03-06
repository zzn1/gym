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
import com.thinkgem.jeesite.modules.yipan.entity.YpCardHolder;
import com.thinkgem.jeesite.modules.yipan.service.YpCardHolderService;

/**
 * 持卡信息Controller
 * @author zcx
 * @version 2020-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/yipan/ypCardHolder")
public class YpCardHolderController extends BaseController {

	@Autowired
	private YpCardHolderService ypCardHolderService;
	
	@ModelAttribute
	public YpCardHolder get(@RequestParam(required=false) String id) {
		YpCardHolder entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ypCardHolderService.get(id);
		}
		if (entity == null){
			entity = new YpCardHolder();
		}
		return entity;
	}
	
	@RequiresPermissions("yipan:ypCardHolder:view")
	@RequestMapping(value = {"list", ""})
	public String list(YpCardHolder ypCardHolder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YpCardHolder> page = ypCardHolderService.findPage(new Page<YpCardHolder>(request, response), ypCardHolder); 
		model.addAttribute("page", page);
		return "modules/yipan/ypCardHolderList";
	}

	@RequiresPermissions("yipan:ypCardHolder:view")
	@RequestMapping(value = "form")
	public String form(YpCardHolder ypCardHolder, Model model) {
		model.addAttribute("ypCardHolder", ypCardHolder);
		return "modules/yipan/ypCardHolderForm";
	}

	@RequiresPermissions("yipan:ypCardHolder:edit")
	@RequestMapping(value = "save")
	public String save(YpCardHolder ypCardHolder, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ypCardHolder)){
			return form(ypCardHolder, model);
		}
		ypCardHolderService.save(ypCardHolder);
		addMessage(redirectAttributes, "保存持卡信息成功");
		return "redirect:"+Global.getAdminPath()+"/yipan/ypCardHolder/?repage";
	}
	
	@RequiresPermissions("yipan:ypCardHolder:edit")
	@RequestMapping(value = "delete")
	public String delete(YpCardHolder ypCardHolder, RedirectAttributes redirectAttributes) {
		ypCardHolderService.delete(ypCardHolder);
		addMessage(redirectAttributes, "删除持卡信息成功");
		return "redirect:"+Global.getAdminPath()+"/yipan/ypCardHolder/?repage";
	}

}