package com.nodesoft.democracy.analyse.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.web.BaseController;
import com.nodesoft.democracy.analyse.service.AnalyseService;
import com.nodesoft.democracy.score.entity.DemScore;


@Controller
@RequestMapping(value = "${adminPath}/democrac")
public class AnalyseController extends BaseController{


	@Autowired
	private AnalyseService analyseService;	
	
	
	@RequestMapping(value = "analyse")
	public String analyse(DemScore demScore, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemScore> page = analyseService.findAnalyse(new Page<DemScore>(request, response), demScore); 
		model.addAttribute("page", page);
		return "democracy/score/demScoreList";
	}
	
}
