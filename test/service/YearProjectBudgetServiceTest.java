package service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import utils.CollectionUtils;
import utils.DateUtils;
import dao.orm.ActivityInfo;
import dao.orm.SubjectInfo;
import dao.orm.YearBudgetDetail;
import dao.orm.YearBudgetHeader;
import dao.orm.YearBudgetMonth;
import dao.orm.YearBudgetMonthId;
import dao.orm.SysOrg;

public class YearProjectBudgetServiceTest {
	private static Logger logger = Logger.getLogger(YearProjectBudgetServiceTest.class);
	private YearProjectBudgetService yearProjectBudgetService;
	
	public void saveBudget(){
		YearBudgetHeader header = new YearBudgetHeader();
		header.setId(4);
		header.setSysOrg(new SysOrg(1));
		header.setAmount(new BigDecimal(1000));
		header.setProjectCode(10001);
		header.setProjectName("四川移动招待费");
		header.setStatus(0);
		header.setUserId("1");
		header.setYear(2014);
		header.setStartDate(DateUtils.getDate("2014-01-01", "yyyy-MM-dd"));
		header.setEndDate(DateUtils.getDate("2014-04-30", "yyyy-MM-dd"));
		Set<YearBudgetDetail> detailSet = new HashSet<YearBudgetDetail>();
		YearBudgetDetail detail = new YearBudgetDetail();
		detail.setId(4);
		detail.setActivityInfo(new ActivityInfo("B0101"));
		detail.setAmount(new BigDecimal(1000));
		detail.setSubjectInfo(new SubjectInfo("P0101"));
		detail.setHeader(header);
		detailSet.add(detail);
		header.setDetailSet(detailSet);
		Set<YearBudgetMonth> monthSet = new HashSet<YearBudgetMonth>();
		YearBudgetMonth month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(4,1));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(4,2));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(4,3));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(4,4));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		detail.setMonthSet(monthSet);
		yearProjectBudgetService.saveBudget(header);
	}
	
	public void updateBudget(){
		YearBudgetHeader header = new YearBudgetHeader();
		header.setId(1);
		header.setSysOrg(new SysOrg(1));
		header.setAmount(new BigDecimal(1000));
		header.setProjectCode(10000);
		header.setProjectName("四川移动建设费");
		header.setStatus(0);
		header.setUserId("1");
		header.setYear(2014);
		header.setStartDate(DateUtils.getDate("2014-01-01", "yyyy-MM-dd"));
		header.setEndDate(DateUtils.getDate("2014-04-30", "yyyy-MM-dd"));
		Set<YearBudgetDetail> detailSet = new HashSet<YearBudgetDetail>();
		YearBudgetDetail detail = new YearBudgetDetail();
		detail.setId(1);
		detail.setActivityInfo(new ActivityInfo("B0101"));
		detail.setAmount(new BigDecimal(1000));
		detail.setSubjectInfo(new SubjectInfo("P0101"));
		detail.setHeader(header);
		detailSet.add(detail);
		header.setDetailSet(detailSet);
		Set<YearBudgetMonth> monthSet = new HashSet<YearBudgetMonth>();
		YearBudgetMonth month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(1,1));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(1,2));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(1,3));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new YearBudgetMonth();
		month.setId(new YearBudgetMonthId(1,4));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		detail.setMonthSet(monthSet);
		yearProjectBudgetService.updateBudget(header);
	}
	
	

	public void getBudgetById() {
		YearBudgetHeader header = yearProjectBudgetService.getBudget(1);
		Set<YearBudgetDetail> detailSet = header.getDetailSet();
		if(CollectionUtils.isNotEmpty(detailSet)){
			for(YearBudgetDetail detail : detailSet){
				System.out.println(detail.getAmount());
			}
		}
		System.out.println(header);
	}

	public void getBudgetByProjectCodeAndYear() {
		YearBudgetHeader header = yearProjectBudgetService.getBudget(10000,2014);
		Set<YearBudgetDetail> detailSet = header.getDetailSet();
		if(CollectionUtils.isNotEmpty(detailSet)){
			for(YearBudgetDetail detail : detailSet){
				logger.info("getAmount"+detail.getAmount());
				
				Set<YearBudgetMonth> monthSet = detail.getMonthSet();
				if(CollectionUtils.isNotEmpty(monthSet)){
					for (YearBudgetMonth month : monthSet) {
						System.out.println(month.getAmount());
					}
				}
			}
		}
		System.out.println(header);
	}

	public void setYearProjectBudgetIssuedService(
			YearProjectBudgetService yearProjectBudgetIssuedService) {
		this.yearProjectBudgetService = yearProjectBudgetIssuedService;
	}
	
	public void updateRejectProject(Integer id) {
		this.yearProjectBudgetService.rejectProject(id);
	}
	
	public void updateSubmitProject(Integer id) {
		this.yearProjectBudgetService.submitProject(id);
	}
	
	public void getOrgProjectReport(Integer orgId,Integer year){
		List<Map<String,Object>> org = this.yearProjectBudgetService.getOrgProjectReport(orgId, year);
		System.out.println(org.get(0).get("org_id"));
	}


}
