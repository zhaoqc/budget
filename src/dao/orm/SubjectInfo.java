package dao.orm;

import java.util.Date;

/**
 * 预算科目实体类.
 * 
 * @author 赵青城
 */

public class SubjectInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3150879586860734883L;
	//科目编号
	private String code;
	//科目名字
	private String name;
	//科目年度
	private Integer year;
	//用户ID
	private Integer userId;
	//输入时间
	private Date entryDatetime;
	//删除时间
	private Date deleteDatetime;
	//删除表的用户ID
	private Integer deleteId;
	//父级编号
	private String parentCode;
	//是否是树的最后一个
	private Byte isEnd;

	// Constructors

	/** default constructor */
	public SubjectInfo() {
	}

	/** minimal constructor */
	public SubjectInfo(String code) {
		this.code = code;
	}

	/** full constructor */
	public SubjectInfo(String code, String name, Integer year, Integer userId,
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