package dao.orm;

import java.io.Serializable;
import java.util.Date;

public class TableIds implements Serializable {

	private static final long serialVersionUID = -6517170484844114970L;

	private String tableName;
	
	private Integer tableMaxId;
	
	private SysUser sysUser;
	
	private Date entryDatetime;
	
	private Date updateDateTime;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getTableMaxId() {
		return tableMaxId;
	}

	public void setTableMaxId(Integer tableMaxId) {
		this.tableMaxId = tableMaxId;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Date getEntryDatetime() {
		return entryDatetime;
	}

	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	
}
