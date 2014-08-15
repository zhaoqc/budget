package dao.orm;

/**
 * SysOrg entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysOrg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3499639910857011657L;
	//机构ID
	private Integer orgId;
	//机构类型 1代表省总公司 2分公司 3部门
	private Integer orgType;
	//机构名字
	private String orgName;
	//父级ID
	private Integer parentId;
	//所属公司
	private Integer compId;
	//所属机构
	private Integer costCenter;

	// Constructors

	/** default constructor */
	public SysOrg() {
	}

	/** minimal constructor */
	public SysOrg(Integer orgId) {
		this.orgId = orgId;
	}

	/** full constructor */
	public SysOrg(Integer orgId, Integer orgType, String orgName,
			Integer parentId, Integer compId, Integer costCenter) {
		this.orgId = orgId;
		this.orgType = orgType;
		this.orgName = orgName;
		this.parentId = parentId;
		this.compId = compId;
		this.costCenter = costCenter;
	}

	// Property accessors

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getOrgType() {
		return this.orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getCompId() {
		return this.compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

}