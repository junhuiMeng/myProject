/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.score.dao;

import java.util.List;

import com.nodesoft.common.persistence.CrudDao;
import com.nodesoft.common.persistence.annotation.MyBatisDao;
import com.nodesoft.democracy.score.entity.DemScore;
import com.nodesoft.modules.sys.entity.Area;
import com.nodesoft.modules.sys.entity.Office;

/**
 * 民主评议分数DAO接口
 * @author yangw
 * @version 2019-12-17
 */
@MyBatisDao
public interface DemScoreDao extends CrudDao<DemScore> {
	
	List<Area> findAreaList(Area area);
	
	List<Office> findUnitList(Office office);


	List<String> getquestiontype(String id);

	List<Office> UnitLbList(Office office);
	
	Office	getcount(Office office);


}


