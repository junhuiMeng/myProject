package com.nodesoft.democracy.score.entity;

import java.util.List;

import com.google.common.collect.Lists;
import com.nodesoft.modules.sys.entity.Office;

public class Unit {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private List<Office> unitlbls =Lists.newArrayList();//单位种类

	
	
	public List<Office> getUnitlbls() {
		return unitlbls;
	}

	public void setUnitlbls(List<Office> unitlbls) {
		this.unitlbls = unitlbls;
	}
	
}
