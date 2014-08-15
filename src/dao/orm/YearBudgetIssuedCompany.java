package dao.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * YearBudgetIssuedCompany entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetIssuedCompany implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7922941901372188473L;
	// Fields

//	年度预算下达ID
	private Integer id;
//	机构ID
	private Integer orgId;
//	年度
	private Integer year;
//	下达金额
	private BigDecimal issuedAmount;
//	创建用户ID
	private Integer userId;
//	创建时间
	private Date entryDatetime;
//	删除用户ID
	private Integer deleteId;
//	删除时间
	private Date deleteDatetime;
//	预留金额
	private BigDecimal reserveAmount;
//	下达说明
	private String comments;
	
	private Set<BudgetCompanyReserve> reservesSet;
	
	private Set<BudgetResourceUsed> resourceUseds;
	
	private Set<BudgetResourceFreezing> resourceFreezings;
	
	private Set<BudgetResourceTotal> resourceTotals;
	
	private Set<BudgetResourceActual> resourceActuals;
	
	// Constructors

	/** default constructor */
	public YearBudgetIssuedCompany() {
	}

	/** minimal constructor */
	public YearBudgetIssuedCompany(Integer id, Integer orgId, Integer year) {
		this.id = id;
		this.orgId = orgId;
		this.year = year;
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

	public BigDecimal getIssuedAmount() {
		return this.issuedAmount;
	}

	public void setIssuedAmount(BigDecimal issuedAmount) {
		this.issuedAmount = issuedAmount;
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

	public BigDecimal getReserveAmount() {
		return this.reserveAmount;
	}

	public void setReserveAmount(BigDecimal reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}