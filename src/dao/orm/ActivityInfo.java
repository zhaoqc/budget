package dao.orm;

import java.util.Date;

/**
 * 业务活动.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ActivityInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6974897605411706496L;
	//业务活动编号
	private String code;
	//业务活动名字
	private String name;
	//业务活动年份
	private Integer year;
	//创建业务的用户ID
	private Integer userId;
	//创建时间
	private Date entryDatetime;
	//删除时间
	private Date deleteDatetime;
	//删除业务的用户ID
	private Integer deleteId;
	//父级编号
	private String parentCode;
	//是否是最底层
	private Byte isEnd;

	// Constructors

	/** default constructor */
	public ActivityInfo() {
	}

	/** minimal constructor */
	public ActivityInfo(String code) {
		this.code = code;
	}

	/** full constructor */
	public ActivityInfo(String code, String name, Integer year, Integer userId,
			Date entryDatetime, Date deleteDatetime, Integer deleteId,
			String parentCode, Byte isEnd) {
		this.code = code;
		this.name = name;
		this.year = year;
		this.userId = userId;
		this.entryDatetime = entryDatetime;
		this.deleteDatetime = deleteDatetime;
		this.deleteId = deleteId;
		this.parentCode = parentCode;
		this.isEnd = isEnd;
	}

	// Property accessors

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
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

	public Date getDeleteDatetime() {
		return this.deleteDatetime;
	}

	public void setDeleteDatetime(Date deleteDatetime) {
		this.deleteDatetime = deleteDatetime;
	}

	public Integer getDeleteId() {
		return this.deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Byte getIsEnd() {
		return this.isEnd;
	}

	public void setIsEnd(Byte isEnd) {
		this.isEnd = isEnd;
	}

}