package dao.orm;

import java.util.Date;

/**
 * 省公司级预留
 * BudgetProvincialReserve entity. @author MyEclipse Persistence Tools
 */

public class BudgetProvincialReserve implements java.io.Serializable {

	private static final long serialVersionUID = -2358291067312608897L;
	// Fields

	private BudgetProvincialReserveId id;
	private Double amount;
	private Integer userId;
	private Date entryDatetime;
	private String comments;

	// Constructors

	/** default constructor */
	public BudgetProvincialReserve() {
	}

	/** minimal constructor */
	public BudgetProvincialReserve(BudgetProvincialReserveId id) {
		this.id = id;
	}

	/** full constructor */
	public BudgetProvincialReserve(BudgetProvincialReserveId id, Double amount,
			Integer userId, Date entryDatetime, String comments) {
		this.id = id;
		this.amount = amount;
		this.userId = userId;
		this.entryDatetime = entryDatetime;
		this.comments = comments;
	}

	// Property accessors

	public BudgetProvincialReserveId getId() {
		return this.id;
	}

	public void setId(BudgetProvincialReserveId id) {
		this.id = id;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}