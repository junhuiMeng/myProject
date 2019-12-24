/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.score.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.service.CrudService;
import com.nodesoft.democracy.score.entity.DemScore;
import com.nodesoft.democracy.score.dao.DemScoreDao;

/**
 * 民主评议分数Service
 * @author yangw
 * @version 2019-12-17
 */
@Service
@Transactional(readOnly = true)
public class DemScoreService extends CrudService<DemScoreDao, DemScore> {

	public DemScore get(String id) { 
		return super.get(id);
	}
	
	public List<DemScore> findList(DemScore demScore) {
		return super.findList(demScore);
	}
	
	public Page<DemScore> findPage(Page<DemScore> page, DemScore demScore) {
		return super.findPage(page, demScore);
	}
	
	@Transactional(readOnly = false)
	public void save(DemScore demScore) {
		super.save(demScore);
	}
	
	@Transactional(readOnly = false)
	public void delete(DemScore demScore) {
		super.delete(demScore);
	}
	
}