package dao.orm;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 分公司级预留
 * BudgetCompanyReserve entity. @author MyEclipse Persistence Tools
 */

public class BudgetCompanyReserve implements java.io.Serializable {

	private static final long serialVersionUID = -7320706048219911638L;

	private BudgetCompanyReserveId id;
//	预留金额
	private BigDecimal amount;
//	创建人
	private Integer userId;
//	创建时间
	private Timestamp entryDatetime;
//	备注
	private String comments;

	// Constructors

	/** default constructor */
	public BudgetCompanyReserve() {
	}

	/** minimal constructor */
	public BudgetCompanyReserve(BudgetCompanyReserveId id) {
		this.id = id;
	}

	/** full constructor */
	public BudgetCompanyReserve(BudgetCompanyReserveId id, BigDecimal amount,
			Integer userId, Timestamp entryDatetime, String comments) {
		this.id = id;
		this.amount = amount;
		this.userId = userId;
		this.entryDatetime = entryDatetime;
		this.comments = comments;
	}

	// Property accessors

	public BudgetCompanyReserveId getId() {
		return this.id;
	}

	public void setId(BudgetCompanyReserveId id) {
		this.id = id;
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}