package com.nodesoft.democracy.utils.gain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nodesoft.democracy.score.dao.DemScoreDao;
import com.nodesoft.modules.sys.entity.Area;
import com.nodesoft.modules.sys.entity.Office;
import com.nodesoft.modules.sys.service.AreaService;
import com.nodesoft.modules.sys.service.OfficeService;


@Controller
@RequestMapping(value = "${adminPath}/utils/unit")
public class UnitGain {

	@Autowired
	private OfficeService officeService;
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private DemScoreDao demScoreDao;
	
	@RequestMapping(value ="unitlist")
	public String unitlist(String qyid) {
		Office office = new Office();
		List<Office> areaList = demScoreDao.findUnitList(office);
		for (Office office2 : areaList) {
			System.out.println(office2.getId()+"===="+office2.getName());
		}
        //model.addAttribute("list", officeService.findList(office));
		return "democracy/score/demScoreList";
	}
	
	
	@RequestMapping(value ="qylist")
	public String qylist(Model model) {
		Area area = new Area();
		List<Area> areaList = demScoreDao.findAreaList(area);
		/*for (Area area2 : areaList) {
			System.out.println(area2.getId()+"===="+area2.getName());
		}*/
		model.addAttribute("list",areaList);
		return "democracy/score/chooseArea";
	}
	
	
}
