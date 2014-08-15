package dao.orm;

import java.math.BigDecimal;
import java.util.Set;

/**
 * YearBudgetDetail entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetDetail implements java.io.Serializable {

	private static final long serialVersionUID = 2237990073111739640L;
//	年度预算详细ID
	private Integer id;
//	年度预算头表
	private YearBudgetHeader header;
//	业务活动编码
	private ActivityInfo activityInfo;
//	科目编码
	private SubjectInfo subjectInfo;
//	金额
	private BigDecimal amount;
//	关联月份
	private Set<YearBudgetMonth> monthSet;


	public Set<YearBudgetMonth> getMonthSet() {
		return monthSet;
	}

	public void setMonthSet(Set<YearBudgetMonth> monthSet) {
		this.monthSet = monthSet;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public YearBudgetHeader getHeader() {
		return header;
	}

	public void setHeader(YearBudgetHeader header) {
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

}