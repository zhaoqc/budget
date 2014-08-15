package dao.impl;

import java.util.Date;

import dao.TableIdsDao;
import dao.orm.SysUser;
import dao.orm.TableIds;

public class TableIdsDaoImpl extends BaseDaoImpl<TableIds> implements TableIdsDao {

	@Override
	public Integer getNextId(String tableName,String userId) {
		TableIds tableIds = super.get(tableName);
		if(tableIds==null){
			tableIds = new TableIds();
			tableIds.setTableName(tableName);
			tableIds.setTableMaxId(1);
			tableIds.setSysUser(new SysUser(userId));
			tableIds.setEntryDatetime(new Date());
			super.add(tableIds);
		}else{
			int maxId = tableIds.getTableMaxId()+1;
			tableIds.setTableMaxId(maxId);
			tableIds.setUpdateDateTime(new Date());
			super.update(tableIds);
		}
		return tableIds.getTableMaxId();
	}

}
