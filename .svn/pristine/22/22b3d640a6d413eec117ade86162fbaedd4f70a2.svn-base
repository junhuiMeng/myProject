/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.democracyuser.web;

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

import com.nodesoft.common.config.Global;
import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.web.BaseController;
import com.nodesoft.common.utils.StringUtils;
import com.nodesoft.democracy.democracyuser.entity.DemUser;
import com.nodesoft.democracy.democracyuser.service.DemUserService;

/**
 * 民主评议人员信息Controller
 * @author yangw
 * @version 2019-12-17
 */
@Controller
@RequestMapping(value = "${adminPath}/democracyuser/demUser")
public class DemUserController extends BaseController {

	@Autowired
	private DemUserService demUserService;
	
	@ModelAttribute
	public DemUser get(@RequestParam(required=false) String id) {
		DemUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demUserService.get(id);
		}
		if (entity == null){
			entity = new DemUser();
		}
		return entity;
	}
	
	@RequiresPermissions("democracyuser:demUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemUser demUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemUser> page = demUserService.findPage(new Page<DemUser>(request, response), demUser); 
		model.addAttribute("page", page);
		return "democracy/democracyuser/demUserList";
	}

	@RequiresPermissions("democracyuser:demUser:view")
	@RequestMapping(value = "form")
	public String form(DemUser demUser, Model model) {
		model.addAttribute("demUser", demUser);
		return "democracy/democracyuser/demUserForm";
	}

	@RequiresPermissions("democracyuser:demUser:edit")
	@RequestMapping(value = "save")
	public String save(DemUser demUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demUser)){
			return form(demUser, model);
		}
		demUserService.save(demUser);
		addMessage(redirectAttributes, "保存民主评议人员信息成功");
		return "redirect:"+Global.getAdminPath()+"/democracyuser/demUser/?repage";
	}
	
	@RequiresPermissions("democracyuser:demUser:edit")
	@RequestMapping(value = "delete")
	public String delete(DemUser demUser, RedirectAttributes redirectAttributes) {
		demUserService.delete(demUser);
		addMessage(redirectAttributes, "删除民主评议人员信息成功");
		return "redirect:"+Global.getAdminPath()+"/democracyuser/demUser/?repage";
	}

}