package dao.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * YearBudgetHeader entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetHeader implements java.io.Serializable {
	
	private static final long serialVersionUID = 2243500682305272068L;
//	年度预算下达头表ID
	private Integer id;
//	机构
	private SysOrg sysOrg;
//	年度预算编号
	private Integer projectCode;
//	项目名字
	private String projectName;
//	创建人ID
	private String userId;
//	审核
	private Integer status;
//	机构ID
	private Integer orgId;
//	年度
	private Integer year;
//	金额
	private BigDecimal amount;
//	项目开始时间
	private Date startDate;
//	结束时间
	private Date endDate;
//	创建表时间
	private Date entryDatetime;
//	更新表时间
	private Date updateDatetime;
//	详细
	private Set<YearBudgetDetail> detailSet;
	
	
	public SysOrg getSysOrg() {
		return sysOrg;
	}

	public void setSysOrg(SysOrg sysOrg) {
		this.sysOrg = sysOrg;
	}

	public Set<YearBudgetDetail> getDetailSet() {
		return detailSet;
	}

	public void setDetailSet(Set<YearBudgetDetail> detailSet) {
		this.detailSet = detailSet;
	}

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

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEntryDatetime() {
		return this.entryDatetime;
	}

	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

}