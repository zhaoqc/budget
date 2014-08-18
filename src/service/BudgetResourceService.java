package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import dao.orm.BudgetResourceFreezing;
import dao.orm.BudgetResourceTotal;
import dao.orm.BudgetResourceUsed;

public interface BudgetResourceService {
	
	/**
	 * 存储总预算资源
	 * @param budgetResourceTotal
	 * @return
	 */
	BudgetResourceTotal seveBudgetResourceTotal(BudgetResourceTotal budgetResourceTotal);
	
	/**
	 * 更新总预算资源
	 * @param budgetResourceTotal
	 * @return
	 */
	BudgetResourceTotal updateBudgetResourceTotal(BudgetResourceTotal budgetResourceTotal);
	
	/**
	 * 根据ID获取总预算资源
	 * @return
	 */
	BudgetResourceTotal getBudgetResourceTotal(Integer id);
	
	/**
	 * 根据项目编号获取总预算资源
	 * @param projectCode
	 * @return
	 */
	BudgetResourceTotal getProjectCodeResourceTotal(Integer projectCode);
	/**
	 * 根据机构ID获取总预算资源
	 * @param orgId
	 * @return
	 */
	List<BudgetResourceTotal> getOrgBudgetResourceTotal(Integer orgId);
	
	/**
	 * 根据机构ID年份获取总预算资源
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<BudgetResourceTotal> getOrgBudgetResourceTotal(Integer orgId,Integer year);
	
	/**
	 * 
	 * 存储冻结预算资源
	 * @param budgetResourceFreezing
	 * @return
	 */
	BudgetResourceFreezing seveBudgetResourceFreezing(BudgetResourceFreezing budgetResourceFreezing);
	
	/**
	 * 更新冻结预算资源
	 * @param budgetResourceFreezing
	 * @return
	 */
	BudgetResourceFreezing updateBudgetResourceFreezing(BudgetResourceFreezing budgetResourceFreezing);
	
	/**
	 * 根据ID获取冻结预算资源
	 * @param id
	 * @return 
	 */
	BudgetResourceFreezing getBudgetResourceFreezing(Integer id);
	
	/**
	 * 根据项目编号获取冻结资源
	 * @param projectCode
	 * @return
	 */
	BudgetResourceFreezing getProjectCodeResourceFreezing(Integer projectCode);
	/**
	 * 根据机构ID获取冻结预算资源
	 * @param orgId
	 * @return
	 */
	List<BudgetResourceFreezing> getOrgBudgetResourceFreezing(Integer orgId);
	
	/**
	 * 根据机构ID年份获取冻结预算资源
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<BudgetResourceFreezing> getOrgBudgetResourceFreezing(Integer orgId,Integer year);
	/**
	 * 存储占用预算资源
	 * @param budgetResourceUsed
	 * @return
	 */
	BudgetResourceUsed seveBudgetResourceUsed(BudgetResourceUsed budgetResourceUsed);
	
	/**
	 * 更新占用预算资源
	 * @param budgetResourceUsed
	 * @return
	 */
	BudgetResourceUsed updateBudgetResourceUsed(BudgetResourceUsed budgetResourceUsed);
	
	/**
	 * 获取占用预算资源
	 * @param id
	 * @return
	 */
	BudgetResourceUsed getBudgetResourceUsed(Integer id);
	
	/**
	 * 根据项目编号获取占用资源
	 * @param projectCode
	 * @return
	 */
	BudgetResourceUsed getProjectCodeResourceUsed(Integer projectCode);
	
	/**
	 * 根据机构ID获取占用预算资源
	 * @param orgId
	 * @return
	 */
	List<BudgetResourceUsed> getOrgBudgetResourceUsed(Integer orgId);
	
	/**
	 * 根据机构ID年份获取占用预算资源
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<BudgetResourceUsed> getOrgBudgetResourceUsed(Integer orgId, Integer year);
	
	/**
	 * 冻结转占用
	 * @param amount
	 * @return map key为"freeze"和"used"
	 */
	Map<String, Object> FreezeToUsed(BigDecimal amount);
	
}
