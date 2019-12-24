/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.democracyuser.entity;

import com.nodesoft.democracy.theme.entity.DemTheme;
import org.hibernate.validator.constraints.Length;

import com.nodesoft.common.persistence.DataEntity;

/**
 * 民主评议人员信息Entity
 * @author yangw
 * @version 2019-12-17
 */
public class DemUser extends DataEntity<DemUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String tel;		// 联系方式
	private String year;		// 年度时间
	private String officeid;		// 小区id
	private String officename;		// 小区名称
	private String opinion;		// 建议
	private String status;      //评审状态
	private String hold1;		// 预留字段1
	private String hold2;		// 预留字段2
	private String hold3;		// 预留字段3
	private String hold4;		// 预留字段4
	private String hold5;		// 预留字段5

	private DemTheme demTheme;

	
	public DemUser() {
		super();
	}

	public DemUser(String id){
		super(id);
	}

	@Length(min=0, max=255, message="名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=255, message="联系方式长度必须介于 1 和 255 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=255, message="年度时间长度必须介于 0 和 255 之间")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@Length(min=0, max=255, message="小区id长度必须介于 0 和 255 之间")
	public String getOfficeid() {
		return officeid;
	}

	public void setOfficeid(String officeid) {
		this.officeid = officeid;
	}
	
	@Length(min=0, max=255, message="小区名称长度必须介于 0 和 255 之间")
	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}
	
	@Length(min=0, max=255, message="建议长度必须介于 0 和 255 之间")
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

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

	public DemTheme getDemTheme() {
		return demTheme;
	}

	public void setDemTheme(DemTheme demTheme) {
		this.demTheme = demTheme;
	}
}