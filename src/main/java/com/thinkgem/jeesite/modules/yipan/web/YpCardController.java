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
import com.thinkgem.jeesite.modules.yipan.entity.YpCard;
import com.thinkgem.jeesite.modules.yipan.service.YpCardService;

/**
 * 卡种管理Controller
 * @author zcx
 * @version 2020-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/yipan/ypCard")
public class YpCardController extends BaseController {

	@Autowired
	private YpCardService ypCardService;
	
	@ModelAttribute
	public YpCard get(@RequestParam(required=false) String id) {
		YpCard entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ypCardService.get(id);
		}
		if (entity == null){
			entity = new YpCard();
		}
		return entity;
	}
	
	@RequiresPermissions("yipan:ypCard:view")
	@RequestMapping(value = {"list", ""})
	public String list(YpCard ypCard, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YpCard> page = ypCardService.findPage(new Page<YpCard>(request, response), ypCard); 
		model.addAttribute("page", page);
		return "modules/yipan/ypCardList";
	}

	@RequiresPermissions("yipan:ypCard:view")
	@RequestMapping(value = "form")
	public String form(YpCard ypCard, Model model) {
		model.addAttribute("ypCard", ypCard);
		return "modules/yipan/ypCardForm";
	}

	@RequiresPermissions("yipan:ypCard:edit")
	@RequestMapping(value = "save")
	public String save(YpCard ypCard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ypCard)){
			return form(ypCard, model);
		}
		ypCardService.save(ypCard);
		addMessage(redirectAttributes, "保存卡种管理成功");
		return "redirect:"+Global.getAdminPath()+"/yipan/ypCard/?repage";
	}
	
	@RequiresPermissions("yipan:ypCard:edit")
	@RequestMapping(value = "delete")
	public String delete(YpCard ypCard, RedirectAttributes redirectAttributes) {
		ypCardService.delete(ypCard);
		addMessage(redirectAttributes, "删除卡种管理成功");
		return "redirect:"+Global.getAdminPath()+"/yipan/ypCard/?repage";
	}

}