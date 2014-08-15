package dao.orm;

/**
 * SysUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3319709510822148646L;
	private String userId;
	private String userName;
	private String account;
	private Integer orgId;
	private String lockFlag;
	private String password;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public SysUser(String userId, String userName, String account,
			Integer orgId, String lockFlag, String password) {
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.orgId = orgId;
		this.lockFlag = lockFlag;
		this.password = password;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getLockFlag() {
		return this.lockFlag;
	}

	public void setLockFlag(String lockFlag) {
		this.lockFlag = lockFlag;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}