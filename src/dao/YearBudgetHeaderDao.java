package dao;

import java.util.List;
import java.util.Map;

import dao.orm.YearBudgetHeader;

public interface YearBudgetHeaderDao extends BaseDao<YearBudgetHeader>{
	
	List<Map<String,Object>> getReport(String sql,Map<String,Object> params);
}
