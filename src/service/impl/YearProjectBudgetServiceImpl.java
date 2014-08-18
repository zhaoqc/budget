package service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import service.YearProjectBudgetService;
import utils.CollectionUtils;
import dao.YearBudgetDetailDao;
import dao.YearBudgetHeaderDao;
import dao.YearBudgetMonthDao;
import dao.orm.YearBudgetDetail;
import dao.orm.YearBudgetHeader;
import dao.orm.YearBudgetMonth;

public class YearProjectBudgetServiceImpl implements YearProjectBudgetService {
	private YearBudgetHeaderDao headerDao;
	private YearBudgetDetailDao detailDao;
	private YearBudgetMonthDao monthDao;

	@Override
	public YearBudgetHeader saveBudget(YearBudgetHeader header) {
		headerDao.add(header);
		Set<YearBudgetDetail> detailSet = header.getDetailSet();
		if (CollectionUtils.isNotEmpty(detailSet)) {
			for (YearBudgetDetail detail : detailSet) {
				detailDao.add(detail);
				Set<YearBudgetMonth> monthSet = detail.getMonthSet();
				if (CollectionUtils.isNotEmpty(monthSet)) {
					for (YearBudgetMonth month : monthSet) {
						monthDao.add(month);
					}
				}
			}
		}
		return header;
	}

	public void setHeaderDao(YearBudgetHeaderDao headerDao) {
		this.headerDao = headerDao;
	}

	public YearBudgetDetailDao getDetailDao() {
		return detailDao;
	}

	public void setDetailDao(YearBudgetDetailDao detailDao) {
		this.detailDao = detailDao;
	}

	public void setMonthDao(YearBudgetMonthDao monthDao) {
		this.monthDao = monthDao;
	}

	@Override
	public YearBudgetHeader getBudget(Integer id) {
		YearBudgetHeader header = headerDao.get(id);
		return header;
	}

	@Override
	public YearBudgetHeader getBudget(Integer projectCode, Integer year) {
		YearBudgetHeader header = null;
		String hql = "from YearBudgetHeader where projectCode=:projectCode and year=:year";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectCode", projectCode);
		params.put("year", year);
		List<YearBudgetHeader> headerList = headerDao.searchByHql(hql,
				params);
		if (CollectionUtils.isNotEmpty(headerList)) {
			header = headerList.get(0);
		}
		return header;
	}

	@Override
	public List<YearBudgetHeader> getHeaderList(Integer orgId, Integer year) {
		String hql = "from YearBudgetHeader where subjectCode=:subjectCode and year=:year";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectCode", orgId);
		params.put("year", year);
		List<YearBudgetHeader> headerList = headerDao.searchByHql(hql,
				params);

		return headerList;
	}

	@Override
	public YearBudgetHeader updateBudget(YearBudgetHeader header) {

		headerDao.update(header);
		Set<YearBudgetDetail> detailSet = header.getDetailSet();
		if (CollectionUtils.isNotEmpty(detailSet)) {
			for (YearBudgetDetail detail : detailSet) {
				detailDao.update(detail);
				Set<YearBudgetMonth> monthSet = detail.getMonthSet();
				if (CollectionUtils.isNotEmpty(monthSet)) {
					for (YearBudgetMonth month : monthSet) {
						monthDao.update(month);
					}
				}
			}
		}
		return header;
	}

	@Override
	public List<Map<String, Object>> getOrgProjectReport(Integer orgId, Integer year) {
		String sql = "SELECT org_id,org_name,year,activity_code,activity_name,subject_code,subject_name,SUM(amount) AS amount FROM " +
				"(SELECT org.org_id,org.org_name,header.year,activity.code AS activity_code ,activity.name AS activity_name,subject.code" +
				"  AS subject_code,subject.name  AS subject_name,detail.amount FROM annual_Budget_header header INNER JOIN " +
				"annual_Budget_detail detail ON header.id = detail.header_id INNER JOIN sys_org org ON header.org_id = org.org_id " +
				"INNER JOIN activity_info activity ON detail.activity_code = activity.code INNER JOIN subject_info subject ON " +
				"detail.subject_code = subject.code ) a WHERE org_id=:orgid and  year=:year GROUP BY org_id,org_name,YEAR," +
				"activity_code,activity_name,subject_code,subject_name";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgid", orgId);
		params.put("year", year);
		List<Map<String,Object>> orgProjectReport = headerDao.getReport(sql,params);
		return orgProjectReport;
	}

	@Override
	public YearBudgetHeader rejectProject(Integer id) {
		YearBudgetHeader header = this.getBudget(id);
		header.setStatus(2);
		headerDao.update(header);
		return header;
	}

	@Override
	public YearBudgetHeader submitProject(Integer id) {
		YearBudgetHeader header = this.getBudget(id);
		header.setStatus(2);
		headerDao.update(header);
		return header;
	}

	@Override
	public YearBudgetHeader endApproveProject(Integer id) {
		YearBudgetHeader header = this.getBudget(id);
		header.setStatus(2);
		headerDao.update(header);
		return header;
	}

	@Override
	public BigDecimal getAvailableResource(String projectCode, Integer year) {
		return null;
	}

}
