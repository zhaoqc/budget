package dao.orm;

import java.math.BigDecimal;

/**
 * YearBudgetMonth entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetMonth implements java.io.Serializable {

	private static final long serialVersionUID = 7484261251451035749L;
//	年度预算月份ID
	private YearBudgetMonthId id;
//	年度预算金额
	private BigDecimal amount;


	public YearBudgetMonthId getId() {
		return this.id;
	}

	public void setId(YearBudgetMonthId id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}