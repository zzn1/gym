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
import com.thinkgem.jeesite.modules.sys.entity.Card;
import com.thinkgem.jeesite.modules.sys.service.CardService;

/**
 * 卡种表方案Controller
 * @author zcx
 * @version 2020-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/card")
public class CardController extends BaseController {

	@Autowired
	private CardService cardService;
	
	@ModelAttribute
	public Card get(@RequestParam(required=false) String id) {
		Card entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cardService.get(id);
		}
		if (entity == null){
			entity = new Card();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:card:view")
	@RequestMapping(value = {"list", ""})
	public String list(Card card, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Card> page = cardService.findPage(new Page<Card>(request, response), card); 
		model.addAttribute("page", page);
		return "modules/sys/cardList";
	}

	@RequiresPermissions("sys:card:view")
	@RequestMapping(value = "form")
	public String form(Card card, Model model) {
		model.addAttribute("card", card);
		return "modules/sys/cardForm";
	}

	@RequiresPermissions("sys:card:edit")
	@RequestMapping(value = "save")
	public String save(Card card, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, card)){
			return form(card, model);
		}
		cardService.save(card);
		addMessage(redirectAttributes, "保存卡种管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/card/?repage";
	}
	
	@RequiresPermissions("sys:card:edit")
	@RequestMapping(value = "delete")
	public String delete(Card card, RedirectAttributes redirectAttributes) {
		cardService.delete(card);
		addMessage(redirectAttributes, "删除卡种管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/card/?repage";
	}

}