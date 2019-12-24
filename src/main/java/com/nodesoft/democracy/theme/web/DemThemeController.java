/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.theme.web;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nodesoft.common.config.Global;
import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.web.BaseController;
import com.nodesoft.common.utils.DateUtils;
import com.nodesoft.common.utils.StringUtils;
import com.nodesoft.democracy.theme.entity.DemTheme;
import com.nodesoft.democracy.theme.service.DemThemeService;
import com.nodesoft.democracy.utils.AjaxJson;

/**
 * 评议议题Controller
 * @author yagnw
 * @version 2019-12-21
 */
@Controller
@RequestMapping(value = "${adminPath}/theme/demTheme")
public class DemThemeController extends BaseController {

	@Autowired
	private DemThemeService demThemeService;
	
	@ModelAttribute
	public DemTheme get(@RequestParam(required=false) String id) {
		DemTheme entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demThemeService.get(id);
		}
		if (entity == null){
			entity = new DemTheme();
		}
		return entity;
	}
	
	@RequiresPermissions("theme:demTheme:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemTheme demTheme, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemTheme> page = demThemeService.findPage(new Page<DemTheme>(request, response), demTheme); 
		model.addAttribute("page", page);
		return "democracy/theme/demThemeList";
	}

	@RequiresPermissions("theme:demTheme:view")
	@RequestMapping(value = "form")
	public String form(DemTheme demTheme, Model model) {
		model.addAttribute("demTheme", demTheme);
		return "democracy/theme/demThemeForm";
	}

	@RequiresPermissions("theme:demTheme:edit")
	@RequestMapping(value = "save")
	public String save(DemTheme demTheme, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demTheme)){
			return form(demTheme, model);
		}
		if(StringUtils.isBlank(demTheme.getId())){
			DemTheme demTheme2 = new DemTheme();
			demTheme2.setYear(demTheme.getYear());
			List<DemTheme> demThemelist =demThemeService.findList(demTheme2);
			if(demThemelist.size()>0){
				addMessage(redirectAttributes, "保存失败，该年度议题已维护");
				return "redirect:"+Global.getAdminPath()+"/theme/demTheme/?repage";
			}
		}
		demThemeService.save(demTheme);
		addMessage(redirectAttributes, "保存评议议题成功");
		return "redirect:"+Global.getAdminPath()+"/theme/demTheme/?repage";
	}
	
	@RequiresPermissions("theme:demTheme:edit")
	@RequestMapping(value = "delete")
	public String delete(DemTheme demTheme, RedirectAttributes redirectAttributes) {
		demThemeService.delete(demTheme);
		addMessage(redirectAttributes, "删除评议议题成功");
		return "redirect:"+Global.getAdminPath()+"/theme/demTheme/?repage";
	}

	//查询最大年份的议题作为发布议题
	/*@RequestMapping(value = "fbtheme")
	public String fbtheme(DemTheme demTheme, RedirectAttributes redirectAttributes) {
		demTheme.setStatus("fbnf");
		List<DemTheme> demThemelist =demThemeService.findList(demTheme);
		demTheme=demThemelist.get(0);
		//addMessage(redirectAttributes, "删除评议议题成功");
		return "redirect:"+Global.getAdminPath()+"/theme/demTheme/?repage";
	}*/
	
	@RequestMapping(value = "fbtheme")
	public DemTheme fbtheme(DemTheme demTheme, RedirectAttributes redirectAttributes) {
		demTheme.setHold1("fbnf");
		List<DemTheme> demThemelist =demThemeService.findList(demTheme);
		if(demThemelist.size()>0){
			demTheme=demThemelist.get(0);
			 SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
			 demTheme.setHold1(ft.format(demTheme.getStartDate()));
			 demTheme.setHold2(ft.format(demTheme.getEndDate()));
		}
		return demTheme;
	}
	


}