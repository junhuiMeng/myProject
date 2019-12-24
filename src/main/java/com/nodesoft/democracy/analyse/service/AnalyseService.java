package com.nodesoft.democracy.analyse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.service.CrudService;
import com.nodesoft.democracy.analyse.dao.AnalyseDao;
import com.nodesoft.democracy.score.entity.DemScore;


@Service
@Transactional(readOnly = true)
public class AnalyseService extends CrudService<AnalyseDao, DemScore>{

	@Autowired
	private AnalyseDao analyseDao;
	
		/*public Page<SaleHouseInfo> findSynHouseListPage(Page<SaleHouseInfo> page, SaleHouseInfo saleHouseInfo) {
			saleHouseInfo.setPage(page);
			page.setList(saleHouseInfoDao.synHouseList(saleHouseInfo));
			return page;
		}*/
	
		public Page<DemScore> findAnalyse(Page<DemScore> page, DemScore demScore) {
			demScore.setPage(page);
			page.setList(analyseDao.findAnalyse(demScore));
			return page;
		}
	
	
	
	
	
}
