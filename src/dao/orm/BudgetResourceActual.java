package dao.orm;

/**
 * BudgetResourceActual entity. @author MyEclipse Persistence Tools
 */

public class BudgetResourceActual implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer projectCode;
	private Integer year;
	private String activityCode;
	private String subjectCode;
	private Double amount;
	private Integer resourceType;
	private Integer referenceId;
	private Integer referenceDetailId;
	private Integer referenceType;

	// Constructors

	/** default constructor */
	public BudgetResourceActual() {
	}

	/** minimal constructor */
	public BudgetResourceActual(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public BudgetResourceActual(Integer id, Integer projectCode, Integer year,
			String activityCode, String subjectCode, Double amount,
			Integer resourceType, Integer referenceId,
			Integer referenceDetailId, Integer referenceType) {
		this.id = id;
		this.projectCode = projectCode;
		this.year = year;
		this.activityCode = activityCode;
		this.subjectCode = subjectCode;
		this.amount = amount;
		this.resourceType = resourceType;
		this.referenceId = referenceId;
		this.referenceDetailId = referenceDetailId;
		this.referenceType = referenceType;
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

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}

	public Integer getReferenceDetailId() {
		return this.referenceDetailId;
	}

	public void setReferenceDetailId(Integer referenceDetailId) {
		this.referenceDetailId = referenceDetailId;
	}

	public Integer getReferenceType() {
		return this.referenceType;
	}

	public void setReferenceType(Integer referenceType) {
		this.referenceType = referenceType;
	}

}