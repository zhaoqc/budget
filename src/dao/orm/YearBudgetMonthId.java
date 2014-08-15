package dao.orm;

/**
 * YearBudgetMonthId联合主键 entity. @author MyEclipse Persistence Tools
 */

public class YearBudgetMonthId implements java.io.Serializable {

	private static final long serialVersionUID = 784445101433186962L;
	
	private Integer detailId;
	private Integer month;

	public YearBudgetMonthId() {
		
	}
	public YearBudgetMonthId(Integer detailId, Integer month) {
		super();
		this.detailId = detailId;
		this.month = month;
	}

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
		if (!(other instanceof YearBudgetMonthId))
			return false;
		YearBudgetMonthId castOther = (YearBudgetMonthId) other;

		return ((this.getDetailId() == castOther.getDetailId()) || (this
				.getDetailId() != null && castOther.getDetailId() != null && this
				.getDetailId().equals(castOther.getDetailId())))
				&& ((this.getMonth() == castOther.getMonth()) || (this
						.getMonth() != null && castOther.getMonth() != null && this
						.getMonth().equals(castOther.getMonth())));
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