package dao.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * 省公司年度预算下达
 * YearBudgetIssuedProvincial entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetIssuedProvincial implements java.io.Serializable {

	private static final long serialVersionUID = 4435444981716409172L;
//	ID
	private Integer id;
//	机构ID
	private Integer orgId;
//	年度
	private Integer year;
//	下达金额
	private BigDecimal issuedAmount;
//	创建人
	private Integer userId;
//	插入时间
	private Date entryDatetime;
//	删除人
	private Integer deleteId;
//	删除时间
	private Date deleteDatetime;
//	备注
	private String comments;
//	预留金额
	private BigDecimal reserveAmount;
//	省公司级别预留
	private Set<BudgetProvincialReserve> reserveSet;


	public BigDecimal getReserveAmount() {
		return reserveAmount;
	}

	public void setReserveAmount(BigDecimal reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	public Set<BudgetProvincialReserve> getReserveSet() {
		return reserveSet;
	}

	public void setReserveSet(Set<BudgetProvincialReserve> reserveSet) {
		this.reserveSet = reserveSet;
	}

	public YearBudgetIssuedProvincial(Integer id) {
		this.id = id;
	}

	public BigDecimal getIssuedAmount() {
		return issuedAmount;
	}

	public void setIssuedAmount(BigDecimal issuedAmount) {
		this.issuedAmount = issuedAmount;
	}

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



	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getEntryDatetime() {
		return this.entryDatetime;
	}

	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	public Integer getDeleteId() {
		return this.deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public Date getDeleteDatetime() {
		return this.deleteDatetime;
	}

	public void setDeleteDatetime(Date deleteDatetime) {
		this.deleteDatetime = deleteDatetime;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



}