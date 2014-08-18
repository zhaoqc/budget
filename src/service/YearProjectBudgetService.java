package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import dao.orm.YearBudgetHeader;

public interface YearProjectBudgetService {
	/**
	 * 根据YearBudgetHeader年度预算头表插入项目信息
	 * @author 赵青城
	 * @param YearBudgetHeader年度预算头表
	 * @return 插入项目信息
	 */
	YearBudgetHeader saveBudget(YearBudgetHeader header);
	/**
	 * 根据YearBudgetHeader年度预算头表更新项目信息
	 * @author 赵青城
	 * @param YearBudgetHeader年度预算头表
	 * @return 更新项目信息
	 */
	YearBudgetHeader updateBudget(YearBudgetHeader header);
	/**
	 * 根据年度项目的id查找该项目的信息
	 * @author 赵春林
	 * @param id 年度项目的主键ID
	 * @return 查找到的项目信息
	 */
	YearBudgetHeader getBudget(Integer id);
	
	/**
	 * 根据年度预算项目的编号和年份查询
	 * @param projectCode
	 * @param year
	 * @return
	 */
	YearBudgetHeader getBudget(Integer projectCode,Integer year);
	
	/**
	 * 根据部门id和年份，查询部门在该年份下的所有项目信息
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<YearBudgetHeader> getHeaderList(Integer orgId,Integer year);
	
	/**
	 * 提交项目的信息，更新项目的状态为1
	 * @param id
	 * @return
	 */
	YearBudgetHeader submitProject(Integer id);
	
	/**
	 * 退回项目到起草人2
	 * @param id
	 * @return
	 */
	YearBudgetHeader rejectProject(Integer id);
	
	/**
	 * 项目审批通过 状态为3
	 * @param id
	 * @return
	 */
	YearBudgetHeader endApproveProject(Integer id);
	/**
	 * 根据部门Id和年份查询项目资源汇总信息。
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<Map<String,Object>> getOrgProjectReport(Integer orgId,Integer year);
	
	BigDecimal getAvailableResource(String projectCode,Integer year);
}
