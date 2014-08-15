package service;

import java.util.List;
import java.util.Map;

import dao.orm.AnnualBudgetingHeader;

public interface YearProjectBudgetingService {
	/**
	 * 根据annualBudgetingHeader年度预算头表插入项目信息
	 * @author 赵青城
	 * @param annualBudgetingHeader年度预算头表
	 * @return 插入项目信息
	 */
	AnnualBudgetingHeader saveBudgeting(AnnualBudgetingHeader header);
	/**
	 * 根据annualBudgetingHeader年度预算头表更新项目信息
	 * @author 赵青城
	 * @param annualBudgetingHeader年度预算头表
	 * @return 更新项目信息
	 */
	AnnualBudgetingHeader updateBudgeting(AnnualBudgetingHeader header);
	/**
	 * 根据年度编制项目的id查找该项目的信息
	 * @author 赵春林
	 * @param id 年度编制项目的主键ID
	 * @return 查找到的项目信息
	 */
	AnnualBudgetingHeader getBudgeting(Integer id);
	
	AnnualBudgetingHeader getBudgeting(Integer projectCode,Integer year);
	
	/**
	 * 根据部门id和年份，查询部门在该年份下的所有项目信息
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<AnnualBudgetingHeader> getHeaderList(Integer orgId,Integer year);
	
	/**
	 * 提交项目的信息，更新项目的状态为1
	 * @param id
	 * @return
	 */
	AnnualBudgetingHeader submitProject(Integer id);
	
	/**
	 * 退回项目到起草人2
	 * @param id
	 * @return
	 */
	AnnualBudgetingHeader rejectProject(Integer id);
	
	/**
	 * 项目审批通过 状态为3
	 * @param id
	 * @return
	 */
	AnnualBudgetingHeader endApproveProject(Integer id);
	/**
	 * 根据部门Id和年份查询项目资源汇总信息。
	 * @param orgId
	 * @param year
	 * @return
	 */
	List<Map<String,Object>> getOrgProjectReport(Integer orgId,Integer year);
}
