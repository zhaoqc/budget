package dao.orm;

import java.math.BigDecimal;
import java.util.Set;

/**
 * AnnualBudgetingDetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AnnualBudgetingDetail implements java.io.Serializable {

	private static final long serialVersionUID = 3848895703933318349L;
	//年度预算详情编制ID
	private Integer id;
	//年度预算编制头表ID
	private AnnualBudgetingHeader header;
	//业务信息
	private ActivityInfo activityInfo;
	//部门信息
	private SubjectInfo subjectInfo;
	//总金额
	private BigDecimal amount;
	//年度预算月
	private Set<AnnualBudgetingMonth> monthSet;

	// Constructors

	/** default constructor */
	public AnnualBudgetingDetail() {
	}

	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public AnnualBudgetingHeader getHeader() {
		return header;
	}


	public void setHeader(AnnualBudgetingHeader header) {
		this.header = header;
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



	public Set<AnnualBudgetingMonth> getMonthSet() {
		return monthSet;
	}



	public void setMonthSet(Set<AnnualBudgetingMonth> monthSet) {
		this.monthSet = monthSet;
	}
	
}