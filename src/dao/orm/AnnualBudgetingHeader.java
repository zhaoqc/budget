package dao.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * AnnualBudgetingHeader entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AnnualBudgetingHeader implements java.io.Serializable {

	private static final long serialVersionUID = -5866288591292279558L;
	//项目主键ID
	private Integer id;
	//项目编码
	private Integer projectCode;
	//项目名称
	private String projectName;
	//用户ID
	private String userId;
	//表的状态
	private Integer status;
	//系统机构
	private SysOrg sysOrg;
	//年度
	private Integer year;
	//金额
	private BigDecimal amount;
	//开始时间
	private Date startDate;
	//结束时间
	private Date endDate;
	//详细
	private Set<AnnualBudgetingDetail> detailSet;

	// Constructors

	/** default constructor */
	public AnnualBudgetingHeader() {
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

	public SysOrg getSysOrg() {
		return sysOrg;
	}

	public void setSysOrg(SysOrg sysOrg) {
		this.sysOrg = sysOrg;
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

	public Set<AnnualBudgetingDetail> getDetailSet() {
		return detailSet;
	}

	public void setDetailSet(Set<AnnualBudgetingDetail> detailSet) {
		this.detailSet = detailSet;
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

	
	

}