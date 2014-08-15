package dao.orm;

/**
 * AnnualBudgetingMonthId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AnnualBudgetingMonthId implements java.io.Serializable {

	private static final long serialVersionUID = -1069421321944464530L;
	//年度预算编制详细编号
	private Integer detailId;
	//年度预算编制月份
	private Integer month;

	// Constructors

	/** default constructor */
	public AnnualBudgetingMonthId() {
	}

	/** full constructor */
	public AnnualBudgetingMonthId(Integer detailId, Integer month) {
		this.detailId = detailId;
		this.month = month;
	}

	// Property accessors

	public Integer getDetailId() {
		return this.detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AnnualBudgetingMonthId))
			return false;
		AnnualBudgetingMonthId castOther = (AnnualBudgetingMonthId) other;

		return ((this.getDetailId() == castOther.getDetailId()) || (this
				.getDetailId() != null
				&& castOther.getDetailId() != null && this.getDetailId()
				.equals(castOther.getDetailId())))
				&& ((this.getMonth() == castOther.getMonth()) || (this
						.getMonth() != null
						&& castOther.getMonth() != null && this.getMonth()
						.equals(castOther.getMonth())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDetailId() == null ? 0 : this.getDetailId().hashCode());
		result = 37 * result
				+ (getMonth() == null ? 0 : this.getMonth().hashCode());
		return result;
	}

}