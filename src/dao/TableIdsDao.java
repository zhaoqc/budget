package dao;

import dao.orm.TableIds;

public interface TableIdsDao extends BaseDao<TableIds> {
	
	Integer getNextId(String tableName,String userId);
}
