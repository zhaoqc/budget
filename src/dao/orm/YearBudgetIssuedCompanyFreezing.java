package dao.orm;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * YearBudgetIssuedCompanyFreezing entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetIssuedCompanyFreezing implements java.io.Serializable {

	
	private static final long serialVersionUID = 9099021675444019345L;
//	冻结ID
	private Integer id;
//	所属机构ID
	private Integer orgId;
//	年份
	private Integer year;
//	冻结金额
	private BigDecimal amount;
//	创建人ID
	private Integer userId;
//	插入时间
	private Timestamp entryDatetime;
//	删除人ID
	private Integer deleteId;
//	删除时间
	private Timestamp deleteDatetime;
//	冻结项目ID
	private Integer projectId;
//	冻结原因
	private String comments;


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

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
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