/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.democracyuser.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.service.CrudService;
import com.nodesoft.democracy.democracyuser.entity.DemUser;
import com.nodesoft.democracy.democracyuser.dao.DemUserDao;

/**
 * 民主评议人员信息Service
 * @author yangw
 * @version 2019-12-17
 */
@Service
@Transactional(readOnly = true)
public class DemUserService extends CrudService<DemUserDao, DemUser> {

	public DemUser get(String id) {
		return super.get(id);
	}
	
	public List<DemUser> findList(DemUser demUser) {
		return super.findList(demUser);
	}
	
	public Page<DemUser> findPage(Page<DemUser> page, DemUser demUser) {
		return super.findPage(page, demUser);
	}
	
	@Transactional(readOnly = false)
	public void save(DemUser demUser) {
		super.save(demUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(DemUser demUser) {
		super.delete(demUser);
	}
	
}