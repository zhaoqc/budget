﻿package dao.orm;

import java.math.BigDecimal;

/**
 * 目前的预算资源 entity. @author MyEclipse Persistence Tools
 */

public class BudgetResourceActual implements java.io.Serializable {


	private static final long serialVersionUID = 7363587215794860678L;
	//	ID
	private Integer id;
//	项目编码
	private Integer projectCode;
//	年份
	private Integer year;
//	业务活动编码
	private String activityCode;
//	科目编码
	private String subjectCode;
//	金额
	private BigDecimal amount;
//	属性 0年度,1日常项目  
	private Integer resourceType;
//	年度预算头表ID
	private Integer referenceId;
//	年度预算详细ID
	private Integer referenceDetailId;
//	机构属性 1.公司;2.分公司;3.部门
	private Integer referenceType;
	// Constructors

	/** default constructor */
	public BudgetResourceActual() {
	}

	/** minimal constructor */
	public BudgetResourceActual(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public BudgetResourceActual(Integer id, Integer projectCode, Integer year,
			String activityCode, String subjectCode, BigDecimal amount,
			Integer resourceType, Integer referenceId,
			Integer referenceDetailId, Integer referenceType) {
		this.id = id;
		this.projectCode = projectCode;
		this.year = year;
		this.activityCode = activityCode;
		this.subjectCode = subjectCode;
		this.amount = amount;
		this.resourceType = resourceType;
		this.referenceId = referenceId;
		this.referenceDetailId = referenceDetailId;
		this.referenceType = referenceType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}

	public Integer getReferenceDetailId() {
		return this.referenceDetailId;
	}

	public void setReferenceDetailId(Integer referenceDetailId) {
		this.referenceDetailId = referenceDetailId;
	}

	public Integer getReferenceType() {
		return this.referenceType;
	}

	public void setReferenceType(Integer referenceType) {
		this.referenceType = referenceType;
	}

}