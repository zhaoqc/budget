package dao;

import java.util.List;
import java.util.Map;

import dao.orm.AnnualBudgetingHeader;

public interface AnnualBudgetingHeaderDao extends BaseDao<AnnualBudgetingHeader> {
	
	List<Map<String,Object>> getReport(String sql,Map<String,Object> params);
}

