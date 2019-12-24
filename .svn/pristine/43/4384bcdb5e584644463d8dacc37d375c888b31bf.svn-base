/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.score.web;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nodesoft.common.config.Global;
import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.utils.StringUtils;
import com.nodesoft.common.web.BaseController;
import com.nodesoft.democracy.score.dao.DemScoreDao;
import com.nodesoft.democracy.score.entity.DemScore;
import com.nodesoft.democracy.score.entity.Unit;
import com.nodesoft.democracy.score.service.DemScoreService;
import com.nodesoft.modules.sys.entity.Area;
import com.nodesoft.modules.sys.entity.Dict;
import com.nodesoft.modules.sys.entity.Office;
import com.nodesoft.modules.sys.utils.DictUtils;

/**
 * 民主评议分数Controller
 * @author yangw
 * @version 2019-12-17
 */
@Controller
@RequestMapping(value = "${adminPath}/score/demScore")
public class DemScoreController extends BaseController {

	@Autowired
	private DemScoreService demScoreService;
	@Autowired
	private DemScoreDao demScoreDao;
	
	@ModelAttribute
	public DemScore get(@RequestParam(required=false) String id) {
		DemScore entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demScoreService.get(id);
		}
		if (entity == null){
			entity = new DemScore();
		}
		return entity;
	}
	
	@RequiresPermissions("score:demScore:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemScore demScore, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemScore> page = demScoreService.findPage(new Page<DemScore>(request, response), demScore); 
		model.addAttribute("page", page);
		return "democracy/score/demScoreList";
	}

	@RequiresPermissions("score:demScore:view")
	@RequestMapping(value = "form")
	public String form(DemScore demScore, Model model) {
		model.addAttribute("demScore", demScore);
		return "democracy/score/demScoreForm";
	}

	@RequiresPermissions("score:demScore:edit")
	@RequestMapping(value = "save")
	public String save(DemScore demScore, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demScore)){
			return form(demScore, model);
		}
		demScoreService.save(demScore);
		addMessage(redirectAttributes, "保存民主评议分数成功");
		return "redirect:"+Global.getAdminPath()+"/score/demScore/?repage";
	}
	
	@RequiresPermissions("score:demScore:edit")
	@RequestMapping(value = "delete")
	public String delete(DemScore demScore, RedirectAttributes redirectAttributes) {
		demScoreService.delete(demScore);
		addMessage(redirectAttributes, "删除民主评议分数成功");
		return "redirect:"+Global.getAdminPath()+"/score/demScore/?repage";
	}
	
	
	
	/**
	 * @Title: qytoscore  
	 * @Description: 根据区域查对应的单位
	 * @param area
	 * @param model
	 * @return
	 * String
	 */
	@RequestMapping(value ="qytoscore")
	public String qytoscore(Area area,Model model) {
		System.out.println(area.getId()+"===="+area.getName());
		DemScore demScore = new DemScore();
		demScore.setArea(area);
		
//		UnitGain unitGain = new UnitGain();
		
		
		Area area2 = new Area();
		area2.setId("");
		
		Office office = new Office();
		office.setArea(area);
		//查询单位
		List<Office> unitList = demScoreDao.findUnitList(office);
		List<Dict> dictList=DictUtils.getDictList("2019");
		if(unitList.size()>0){
			for (Office office2 : unitList) {
				if(dictList.size()>0){
					office2.setDictPyList(dictList);
		}
	}
			demScore.setUnitList(unitList);
		}
		
		
		//查询单位类别
		List<Office> unitlb = demScoreDao.UnitLbList(office);
		//查询单位类别数量
		Office countlb = demScoreDao.getcount(office);
		
		if(unitlb.size()>0){
			demScore.setUnitlbList(unitlb);
		}
		
		if(countlb!=null){
			demScore.setDwlbzs(countlb.getEmail());
		}
		
		
		
		if (dictList.size()>0) {
			demScore.setDictList(dictList);
		}
		model.addAttribute("demScore",demScore);
		return "democracy/score/demoPage";
	}

	/**
	 * @Title: qytoscore  
	 * @Description: 根据区域查对应的单位（带类别）
	 * @param area
	 * @param model
	 */
	@RequestMapping(value ="qytoscore2")
	public Unit qytoscore2(Area area,Model model) {
		System.out.println(area.getId()+"===="+area.getName());
		Office office = new Office();
		office.setArea(area);
		//查询单位类别
		List<Office> unitlbs = demScoreDao.UnitLbList(office);
		Unit units = new Unit();
		
		//查询单位
//		List<Office> unitList = demScoreDao.findUnitList(office);
		
		//获取评议选项
		List<Dict> dictList=DictUtils.getDictList("2019");
		
		/*if(unitList.size()>0){
			for (Office office2 : unitList) {
				if(dictList.size()>0){
					office2.setDictPyList(dictList);
				}
			}
		}*/
		
		if(unitlbs.size()>0){
			for (Office lboffice : unitlbs) {
				office.setEmail(lboffice.getEmail());
				//查询单位
				List<Office> unitLista = demScoreDao.findUnitList(office);
				lboffice.setUnitList(unitLista);
			}
			units.setUnitlbls(unitlbs);
		}
		
		if(units.getUnitlbls()!=null){
			for (Office o : units.getUnitlbls()) {
				if(o.getUnitList()!=null){
					for (Office oi : o.getUnitList()) {
						oi.setDictPyList(dictList);
					}
					
				}
			}
		}
		
		/*if(unitlbs.size()>0){
			for (Office lboffice : unitlbs) {
				for (Office unit : unitList) {
					if(lboffice.getEmail().equals(unit.getEmail())){
						lboffice.getUnitList().add(unit);
					}
				}
			}
			
		}*/
		
		return units;
	}
}