package service;

import dao.orm.YearBudgetIssuedCompany;

public interface YearBudgetIssuedCompanyService {

	/**
	 * 插入分公司级年度预算下达
	 * 
	 * @param budgetIssuedCompany
	 * @return
	 */
	YearBudgetIssuedCompany saveBudgetIssuedCompany(
			YearBudgetIssuedCompany budgetIssuedCompany);

	/**
	 * 更新分公司级年度预算下达
	 * 
	 * @param budgetIssuedCompany
	 * @return
	 */
	YearBudgetIssuedCompany updateBudgetIssuedCompany(
			YearBudgetIssuedCompany budgetIssuedCompany);

	/**
	 * 根据ID查询省公司年度下达
	 * 
	 * @param id
	 * @return
	 */
	YearBudgetIssuedCompany getBudgetIssuedCompany(Integer id);

}
