package com.nodesoft.democracy.analyse.dao;

import java.util.List;

import com.nodesoft.common.persistence.CrudDao;
import com.nodesoft.common.persistence.annotation.MyBatisDao;
import com.nodesoft.democracy.score.entity.DemScore;

@MyBatisDao
public interface AnalyseDao extends CrudDao<DemScore>{
	
	public List<DemScore> findAnalyse(DemScore demScore);

}
