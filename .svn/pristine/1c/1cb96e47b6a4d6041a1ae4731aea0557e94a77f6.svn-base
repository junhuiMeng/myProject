/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.score.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.nodesoft.common.persistence.DataEntity;
import com.nodesoft.modules.sys.entity.Area;
import com.nodesoft.modules.sys.entity.Dict;
import com.nodesoft.modules.sys.entity.Office;

/**
 * 民主评议分数Entity
 * @author yangw
 * @version 2019-12-17
 */
public class DemScore extends DataEntity<DemScore> {
	
	private static final long serialVersionUID = 1L;
	private String personid;		// 人员id
	private String officeid;		// 行政区域id
	private String officename;		// 部门名称
	private String reviewType;		// 评审类型
	private String year;		// 评审年度
	private String result;		// 分数
	private String status;		// 评审状态
	private String hold1;		// 预留字段1
	private String hold2;		// 预留字段2
	private String hold3;		// 预留字段3
	private String hold4;		// 预留字段4
	private String hold5;		// 预留字段5
	
	
	private Area area;
	private List<Office> unitList =Lists.newArrayList();
	private List<Dict> dictList =Lists.newArrayList();
	private String dwlbzs; //单位类别总数
	private List<Office> unitlbList =Lists.newArrayList();//单位种类
	
	public DemScore() {
		super();
	}

	public DemScore(String id){
		super(id);
	}

	@Length(min=0, max=255, message="人员id长度必须介于 0 和 255 之间")
	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}
	
	@Length(min=0, max=255, message="行政区域id长度必须介于 0 和 255 之间")
	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	
	@Length(min=0, max=255, message="部门名称长度必须介于 0 和 255 之间")
	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}
	
	@Length(min=0, max=255, message="评审类型长度必须介于 0 和 255 之间")
	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Length(min=0, max=255, message="分数长度必须介于 0 和 255 之间")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Length(min=0, max=1, message="评审状态长度必须介于 0 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getHold1() {
		return hold1;
	}

	public void setHold1(String hold1) {
		this.hold1 = hold1;
	}
	
	public String getHold2() {
		return hold2;
	}

	public void setHold2(String hold2) {
		this.hold2 = hold2;
	}
	
	public String getHold3() {
		return hold3;
	}

	public void setHold3(String hold3) {
		this.hold3 = hold3;
	}
	
	public String getHold4() {
		return hold4;
	}

	public void setHold4(String hold4) {
		this.hold4 = hold4;
	}
	
	public String getHold5() {
		return hold5;
	}

	public void setHold5(String hold5) {
		this.hold5 = hold5;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Office> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<Office> unitList) {
		this.unitList = unitList;
	}

	public List<Dict> getDictList() {
		return dictList;
	}

	public void setDictList(List<Dict> dictList) {
		this.dictList = dictList;
	}

	public String getDwlbzs() {
		return dwlbzs;
	}

	public void setDwlbzs(String dwlbzs) {
		this.dwlbzs = dwlbzs;
	}

	public List<Office> getUnitlbList() {
		return unitlbList;
	}

	public void setUnitlbList(List<Office> unitlbList) {
		this.unitlbList = unitlbList;
	}

}