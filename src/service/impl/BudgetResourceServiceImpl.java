package service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import dao.BudgetResourceFreezingDao;
import dao.BudgetResourceTotalDao;
import dao.BudgetResourceUsedDao;
import dao.orm.BudgetResourceFreezing;
import dao.orm.BudgetResourceTotal;
import dao.orm.BudgetResourceUsed;
import service.BudgetResourceService;
import utils.CollectionUtils;

public class BudgetResourceServiceImpl implements BudgetResourceService {
	private BudgetResourceTotalDao totalDao;
	private BudgetResourceFreezingDao freezingDao;
	private BudgetResourceUsedDao usedDao;
	
	@Override
	public BudgetResourceTotal seveBudgetResourceTotal(
			BudgetResourceTotal budgetResourceTotal) {
		totalDao.add(budgetResourceTotal);
		return budgetResourceTotal;
	}

	@Override
	public BudgetResourceTotal updateBudgetResourceTotal(
			BudgetResourceTotal budgetResourceTotal) {
		totalDao.update(budgetResourceTotal);
		return budgetResourceTotal;
	}

	@Override
	public BudgetResourceTotal getBudgetResourceTotal(Integer id) {
		BudgetResourceTotal budgetResourceTotal = totalDao.get(id);
		return budgetResourceTotal;
	}

	@Override
	public BudgetResourceTotal getProjectCodeResourceTotal(Integer projectCode) {
		BudgetResourceTotal budgetResourceTotal = null;
		String hql = "from BudgetResourceTotal where projectCode=:projectCode";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectCode", projectCode);
		List<BudgetResourceTotal> budgetResourceTotalsList = totalDao.searchByHql(hql,
				params);
		if (CollectionUtils.isNotEmpty(budgetResourceTotalsList)) {
			budgetResourceTotal = budgetResourceTotalsList.get(0);
		}
		return budgetResourceTotal;

	}

	@Override
	public List<BudgetResourceTotal> getOrgBudgetResourceTotal(Integer orgId) {
		String hql = "from BudgetResourceTotal where orgId=:orgId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId", orgId);
		List<BudgetResourceTotal> budgetResourceTotalsList = totalDao.searchByHql(hql,
				params);
		
		return budgetResourceTotalsList;
	}

	@Override
	public List<BudgetResourceTotal> getOrgBudgetResourceTotal(Integer orgId,
			Integer year) {
		String hql = "from BudgetResourceTotal where orgId=:orgId and year=:year";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId", orgId);
		params.put("year", year);
		List<BudgetResourceTotal> budgetResourceTotalsList = totalDao.searchByHql(hql,
				params);
		
		return budgetResourceTotalsList;
	}

	@Override
	public BudgetResourceFreezing seveBudgetResourceFreezing(
			BudgetResourceFreezing budgetResourceFreezing) {
		freezingDao.add(budgetResourceFreezing);
		return budgetResourceFreezing;
	}

	@Override
	public BudgetResourceFreezing updateBudgetResourceFreezing(
			BudgetResourceFreezing budgetResourceFreezing) {
		freezingDao.update(budgetResourceFreezing);
		return budgetResourceFreezing;
	}

	@Override
	public BudgetResourceFreezing getBudgetResourceFreezing(Integer id) {
		BudgetResourceFreezing budgetResourceFreezing = freezingDao.get(id);
		return budgetResourceFreezing;
	}

	@Override
	public BudgetResourceFreezing getProjectCodeResourceFreezing(
			Integer projectCode) {
		BudgetResourceFreezing budgetResourceFreezing = null;
		String hql = "from BudgetResourceFreezing where projectCode=:projectCode";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectCode", projectCode);
		List<BudgetResourceFreezing> budgetResourceFreezings = freezingDao.searchByHql(hql,
				params);
		if (CollectionUtils.isNotEmpty(budgetResourceFreezings)) {
			budgetResourceFreezing = budgetResourceFreezings.get(0);
		}
		return budgetResourceFreezing;
	}

	@Override
	public List<BudgetResourceFreezing> getOrgBudgetResourceFreezing(
			Integer orgId) {
		String hql = "from BudgetResourceFreezing where orgId=:orgId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId", orgId);
		List<BudgetResourceFreezing> budgetResourceFreezings = freezingDao.searchByHql(hql,
				params);
		return budgetResourceFreezings;
	}

	@Override
	public List<BudgetResourceFreezing> getOrgBudgetResourceFreezing(
			Integer orgId, Integer year) {
		String hql = "from BudgetResourceFreezing where orgId=:orgId and year=:year";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId", orgId);
		params.put("year", year);
		List<BudgetResourceFreezing> budgetResourceFreezings = freezingDao.searchByHql(hql,
				params);
		return budgetResourceFreezings;
	}

	@Override
	public BudgetResourceUsed seveBudgetResourceUsed(
			BudgetResourceUsed budgetResourceUsed) {
		BudgetResourceFreezing budgetResourceFreezing = this
				.getProjectCodeResourceFreezing(budgetResourceUsed
						.getProjectCode());
		budgetResourceFreezing.setAmount(budgetResourceFreezing.getAmount()
				.subtract(budgetResourceUsed.getAmount()));
		this.updateBudgetResourceFreezing(budgetResourceFreezing);
		usedDao.add(budgetResourceUsed);
		return budgetResourceUsed;
	}

	@Override
	public BudgetResourceUsed updateBudgetResourceUsed(
			BudgetResourceUsed budgetResourceUsed) {
		usedDao.update(budgetResourceUsed);
		return budgetResourceUsed;
	}

	@Override
	public BudgetResourceUsed getBudgetResourceUsed(Integer id) {
		return usedDao.get(id);
	}

	@Override
	public BudgetResourceUsed getProjectCodeResourceUsed(Integer projectCode) {
		String hql = "FROM BudgetResourceUsed WHERE projectCode=:projectCode";
		Map<String, Object> parmas = new HashMap<String, Object>();
		parmas.put("projectCode", projectCode);
		List<BudgetResourceUsed> budgetResourceUseds = usedDao.searchByHql(hql, parmas);
		BudgetResourceUsed budgetResourceUsed = null;
		if (CollectionUtils.isNotEmpty(budgetResourceUseds)) {
			budgetResourceUsed = budgetResourceUseds.get(0);
		}
		return budgetResourceUsed;
	}

	@Override
	public List<BudgetResourceUsed> getOrgBudgetResourceUsed(Integer orgId) {
		String hql = "FROM BudgetResourceUsed WHERE orgId=:orgId";
		Map<String, Object> parmas = new HashMap<String, Object>();
		parmas.put("orgId", orgId);
		List<BudgetResourceUsed> budgetResourceUseds = usedDao.searchByHql(hql, parmas);
		return budgetResourceUseds;
	}

	@Override
	public List<BudgetResourceUsed> getOrgBudgetResourceUsed(Integer orgId,
			Integer year) {
		String hql = "FROM BudgetResourceUsed WHERE orgId=:orgId and year=:year";
		Map<String, Object> parmas = new HashMap<String, Object>();
		parmas.put("orgId", orgId);
		parmas.put("year", year);
		List<BudgetResourceUsed> budgetResourceUseds = usedDao.searchByHql(hql, parmas);
		return budgetResourceUseds;
	}

	@Override
	public Map<String, Object> FreezeToUsed( BigDecimal amount) {
		return null;
	}

}
