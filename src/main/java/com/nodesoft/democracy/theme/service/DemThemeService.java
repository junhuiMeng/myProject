/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.theme.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nodesoft.common.persistence.Page;
import com.nodesoft.common.service.CrudService;
import com.nodesoft.democracy.theme.entity.DemTheme;
import com.nodesoft.democracy.theme.dao.DemThemeDao;

/**
 * 评议议题Service
 * @author yagnw
 * @version 2019-12-21
 */
@Service
@Transactional(readOnly = true)
public class DemThemeService extends CrudService<DemThemeDao, DemTheme> {

	public DemTheme get(String id) {
		return super.get(id);
	}
	
	public List<DemTheme> findList(DemTheme demTheme) {
		return super.findList(demTheme);
	}
	
	public Page<DemTheme> findPage(Page<DemTheme> page, DemTheme demTheme) {
		return super.findPage(page, demTheme);
	}
	
	@Transactional(readOnly = false)
	public void save(DemTheme demTheme) {
		super.save(demTheme);
	}
	
	@Transactional(readOnly = false)
	public void delete(DemTheme demTheme) {
		super.delete(demTheme);
	}
	
}