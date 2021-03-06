﻿package dao.orm;

/**
 * BudgetCompanyReserveId entity. @author MyEclipse Persistence Tools
 */

public class BudgetCompanyReserveId implements java.io.Serializable {

	private static final long serialVersionUID = -5263980644995645575L;
	private Integer orgId;
	private Integer year;
	private Integer version;

	// Constructors

	/** default constructor */
	public BudgetCompanyReserveId() {
	}

	/** full constructor */
	public BudgetCompanyReserveId(Integer orgId, Integer year, Integer version) {
		this.orgId = orgId;
		this.year = year;
		this.version = version;
	}

	// Property accessors

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

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BudgetCompanyReserveId))
			return false;
		BudgetCompanyReserveId castOther = (BudgetCompanyReserveId) other;

		return ((this.getOrgId() == castOther.getOrgId()) || (this.getOrgId() != null
				&& castOther.getOrgId() != null && this.getOrgId().equals(
				castOther.getOrgId())))
				&& ((this.getYear() == castOther.getYear()) || (this.getYear() != null
						&& castOther.getYear() != null && this.getYear()
						.equals(castOther.getYear())))
				&& ((this.getVersion() == castOther.getVersion()) || (this
						.getVersion() != null && castOther.getVersion() != null && this
						.getVersion().equals(castOther.getVersion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrgId() == null ? 0 : this.getOrgId().hashCode());
		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result
				+ (getVersion() == null ? 0 : this.getVersion().hashCode());
		return result;
	}

}