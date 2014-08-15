package dao.orm;

import java.sql.Timestamp;

/**
 * YearBudgetIssuedCompanyUsed entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetIssuedCompanyUsed implements java.io.Serializable {


	private static final long serialVersionUID = 1176027100852092450L;
//	占用ID
	private Integer id;
//	占用所属机构
	private Integer orgId;
//	年份
	private Integer year;
//	金额
	private Double amount;
//	插入人ID
	private Integer userId;
//	插入时间
	private Timestamp entryDatetime;
//	删除人ID
	private Integer deleteId;
//	删除时间
	private Timestamp deleteDatetime;
//	占用项目ID
	private Integer projectId;
//	占用说明
	private String comments;

	// Constructors

	/** default constructor */
	public YearBudgetIssuedCompanyUsed() {
	}

	/** minimal constructor */
	public YearBudgetIssuedCompanyUsed(Integer id, Integer orgId, Integer year) {
		this.id = id;
		this.orgId = orgId;
		this.year = year;
	}

	/** full constructor */
	public YearBudgetIssuedCompanyUsed(Integer id, Integer orgId, Integer year,
			Double amount, Integer userId, Timestamp entryDatetime,
			Integer deleteId, Timestamp deleteDatetime, Integer projectId,
			String comments) {
		this.id = id;
		this.orgId = orgId;
		this.year = year;
		this.amount = amount;
		this.userId = userId;
		this.entryDatetime = entryDatetime;
		this.deleteId = deleteId;
		this.deleteDatetime = deleteDatetime;
		this.projectId = projectId;
		this.comments = comments;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getEntryDatetime() {
		return this.entryDatetime;
	}

	public void setEntryDatetime(Timestamp entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	public Integer getDeleteId() {
		return this.deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public Timestamp getDeleteDatetime() {
		return this.deleteDatetime;
	}

	public void setDeleteDatetime(Timestamp deleteDatetime) {
		this.deleteDatetime = deleteDatetime;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}