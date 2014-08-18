package dao.orm;

import java.math.BigDecimal;


/**
 *冻结预算资源实体类 @author zhaoqc
 *
 */
public class BudgetResourceFreezing implements java.io.Serializable {


	private static final long serialVersionUID = -145825051243578758L;
	//	ID
	private Integer id;
//	项目编码
	private Integer projectCode;
//	年份
	private Integer year;
//	业务活动
	private ActivityInfo activityInfo;
//	科目
	private SubjectInfo subjectInfo;
	private BigDecimal amount;
//	属性 0年度,1日常项目  
	private Integer resourceType;
//	年度预算头表ID
	private Integer referenceId;
//	年度预算详细ID
	private Integer referenceDetailId;
//	机构属性 1.公司;2.分公司;3.部门
	private Integer referenceType;


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

	public ActivityInfo getActivityInfo() {
		return activityInfo;
	}

	public void setActivityInfo(ActivityInfo activityInfo) {
		this.activityInfo = activityInfo;
	}

	public SubjectInfo getSubjectInfo() {
		return subjectInfo;
	}

	public void setSubjectInfo(SubjectInfo subjectInfo) {
		this.subjectInfo = subjectInfo;
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