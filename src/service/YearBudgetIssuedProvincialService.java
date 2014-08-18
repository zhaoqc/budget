package service;

import dao.orm.YearBudgetIssuedProvincial;

public interface YearBudgetIssuedProvincialService {

	/**
	 * 插入省公司级年度预算下达
	 * 
	 * @param budgetIssuedProvincial
	 * @return
	 */
	YearBudgetIssuedProvincial saveBudgetIssuedProvincial(
			YearBudgetIssuedProvincial budgetIssuedProvincial);

	/**
	 * 更新省公司级年度预算下达
	 * 
	 * @param budgetIssuedProvincial
	 * @return
	 */
	YearBudgetIssuedProvincial updateBudgetIssuedProvincial(
			YearBudgetIssuedProvincial budgetIssuedProvincial);

	/**
	 * 根据ID查询省公司年度下达
	 * 
	 * @param id
	 * @return
	 */
	YearBudgetIssuedProvincial getBudgetIssuedProvincial(Integer id);
	

}
