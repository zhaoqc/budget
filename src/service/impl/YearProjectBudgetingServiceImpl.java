package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import service.YearProjectBudgetingService;
import utils.CollectionUtils;
import dao.AnnualBudgetingDetailDao;
import dao.AnnualBudgetingHeaderDao;
import dao.AnnualBudgetingMonthDao;
import dao.orm.AnnualBudgetingDetail;
import dao.orm.AnnualBudgetingHeader;
import dao.orm.AnnualBudgetingMonth;

public class YearProjectBudgetingServiceImpl implements
		YearProjectBudgetingService {
	private AnnualBudgetingHeaderDao headerDao;
	private AnnualBudgetingDetailDao detailDao;
	private AnnualBudgetingMonthDao monthDao;

	@Override
	public AnnualBudgetingHeader saveBudgeting(AnnualBudgetingHeader header) {
		headerDao.add(header);
		Set<AnnualBudgetingDetail> detailSet = header.getDetailSet();
		if (CollectionUtils.isNotEmpty(detailSet)) {
			for (AnnualBudgetingDetail detail : detailSet) {
				detailDao.add(detail);
				Set<AnnualBudgetingMonth> monthSet = detail.getMonthSet();
				if (CollectionUtils.isNotEmpty(monthSet)) {
					for (AnnualBudgetingMonth month : monthSet) {
						monthDao.add(month);
					}
				}
			}
		}
		return header;
	}

	public void setHeaderDao(AnnualBudgetingHeaderDao headerDao) {
		this.headerDao = headerDao;
	}

	public AnnualBudgetingDetailDao getDetailDao() {
		return detailDao;
	}

	public void setDetailDao(AnnualBudgetingDetailDao detailDao) {
		this.detailDao = detailDao;
	}

	public void setMonthDao(AnnualBudgetingMonthDao monthDao) {
		this.monthDao = monthDao;
	}

	@Override
	public AnnualBudgetingHeader getBudgeting(Integer id) {
		AnnualBudgetingHeader header = headerDao.get(id);
		return header;
	}

	@Override
	public AnnualBudgetingHeader getBudgeting(Integer projectCode, Integer year) {
		AnnualBudgetingHeader header = null;
		String hql = "from AnnualBudgetingHeader where projectCode=:projectCode and year=:year";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectCode", projectCode);
		params.put("year", year);
		List<AnnualBudgetingHeader> headerList = headerDao.searchByHql(hql,
				params);
		if (CollectionUtils.isNotEmpty(headerList)) {
			header = headerList.get(0);
		}
		return header;
	}

	@Override
	public List<AnnualBudgetingHeader> getHeaderList(Integer orgId, Integer year) {
		String hql = "from AnnualBudgetingHeader where subjectCode=:subjectCode and year=:year";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectCode", orgId);
		params.put("year", year);
		List<AnnualBudgetingHeader> headerList = headerDao.searchByHql(hql,
				params);

		return headerList;
	}

	@Override
	public AnnualBudgetingHeader updateBudgeting(AnnualBudgetingHeader header) {

		headerDao.update(header);
		Set<AnnualBudgetingDetail> detailSet = header.getDetailSet();
		if (CollectionUtils.isNotEmpty(detailSet)) {
			for (AnnualBudgetingDetail detail : detailSet) {
				detailDao.update(detail);
				Set<AnnualBudgetingMonth> monthSet = detail.getMonthSet();
				if (CollectionUtils.isNotEmpty(monthSet)) {
					for (AnnualBudgetingMonth month : monthSet) {
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
				"  AS subject_code,subject.name  AS subject_name,detail.amount FROM annual_budgeting_header header INNER JOIN " +
				"annual_budgeting_detail detail ON header.id = detail.header_id INNER JOIN sys_org org ON header.org_id = org.org_id " +
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
	public AnnualBudgetingHeader rejectProject(Integer id) {
		AnnualBudgetingHeader header = this.getBudgeting(id);
		header.setStatus(2);
		headerDao.update(header);
		return header;
	}

	@Override
	public AnnualBudgetingHeader submitProject(Integer id) {
		AnnualBudgetingHeader header = this.getBudgeting(id);
		header.setStatus(2);
		headerDao.update(header);
		return header;
	}

	@Override
	public AnnualBudgetingHeader endApproveProject(Integer id) {
		AnnualBudgetingHeader header = this.getBudgeting(id);
		header.setStatus(2);
		headerDao.update(header);
		return header;
	}

}
