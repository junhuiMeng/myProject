package com.nodesoft.democracy.utils.gain;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nodesoft.modules.sys.entity.Dict;
import com.nodesoft.modules.sys.utils.DictUtils;


@Controller
@RequestMapping(value = "${adminPath}/utils/grade")
public class GradeType {

	@RequestMapping(value = "gradetype")
	public String persontype(String type,Model model) {
		List<Dict> dictList=DictUtils.getDictList("dem_type");
		model.addAttribute("dictList", dictList); 
		return "评议列表页面";
	}
	
}
