/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nodesoft.democracy.theme.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.nodesoft.common.persistence.DataEntity;

/**
 * 评议议题Entity
 * @author yagnw
 * @version 2019-12-21
 */
public class DemTheme extends DataEntity<DemTheme> {
	
	private static final long serialVersionUID = 1L;
	private String year;		// 年度
	private String theme;		// 议题
	private Date startDate;		// start_date
	private Date endDate;		// end_date
	private String attention;		// 协议
	private String hold1;		// 预留字段1
	private String hold2;		// 预留字段2
	private String hold3;		// 预留字段3
	private String hold4;		// 预留字段4
	private String hold5;		// 预留字段5
	private String status;		// 状态
	
	public DemTheme() {
		super();
	}

	public DemTheme(String id){
		super(id);
	}

//	@Length(min=0, max=10, message="年度长度必须介于 0 和 10 之间")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
//	@Length(min=0, max=255, message="议题长度必须介于 0 和 255 之间")
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

//	@Length(min=0, max=600, message="协议长度必须介于 0 和 600 之间")
	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
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
	
	@Length(min=0, max=6, message="状态长度必须介于 0 和 6 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}