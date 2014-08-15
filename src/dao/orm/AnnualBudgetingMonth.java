package dao.orm;

import java.math.BigDecimal;

/**
 * AnnualBudgetingMonth entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AnnualBudgetingMonth implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6607984450323165145L;
	private AnnualBudgetingMonthId id;
	private BigDecimal amount;

	// Constructors

	/** default constructor */
	public AnnualBudgetingMonth() {
	}

	/** minimal constructor */
	public AnnualBudgetingMonth(AnnualBudgetingMonthId id) {
		this.id = id;
	}


	// Property accessors

	public AnnualBudgetingMonthId getId() {
		return this.id;
	}

	public void setId(AnnualBudgetingMonthId id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}