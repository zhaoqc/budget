package service.impl;

import java.util.Set;

import dao.BudgetProvincialReserveDao;
import dao.YearBudgetIssuedProvincialDao;
import dao.orm.BudgetProvincialReserve;
import dao.orm.YearBudgetIssuedProvincial;
import service.YearBudgetIssuedProvincialService;
import utils.CollectionUtils;

public class YearBudgetIssuedProvincialServiceImpl implements YearBudgetIssuedProvincialService{
	private YearBudgetIssuedProvincialDao budgetIssuedProvincialDao;
	private BudgetProvincialReserveDao provincialReserveDao;
	
	@Override
	public YearBudgetIssuedProvincial saveBudgetIssuedProvincial(
			YearBudgetIssuedProvincial budgetIssuedProvincial) {
		budgetIssuedProvincialDao.add(budgetIssuedProvincial);
		Set<BudgetProvincialReserve> reserveSet = budgetIssuedProvincial.getReserveSet();
		if (CollectionUtils.isNotEmpty(reserveSet)) {
			for (BudgetProvincialReserve reserve : reserveSet) {
				provincialReserveDao.add(reserve);
			}
		}
		return budgetIssuedProvincial;
	}

	@Override
	public YearBudgetIssuedProvincial updateBudgetIssuedProvincial(
			YearBudgetIssuedProvincial budgetIssuedProvincial) {
		budgetIssuedProvincialDao.update(budgetIssuedProvincial);
		Set<BudgetProvincialReserve> reserveSet = budgetIssuedProvincial.getReserveSet();
		if (CollectionUtils.isNotEmpty(reserveSet)) {
			for (BudgetProvincialReserve reserve : reserveSet) {
				provincialReserveDao.update(reserve);
			}
		}
		return budgetIssuedProvincial;
	}

	@Override
	public YearBudgetIssuedProvincial getBudgetIssuedProvincial(Integer id) {
		YearBudgetIssuedProvincial budgetIssuedProvincial = budgetIssuedProvincialDao.get(id);
		return budgetIssuedProvincial;
	}
	
	

}
