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
import dao.orm.AnnualBudgetingDetail;
import dao.orm.AnnualBudgetingHeader;
import dao.orm.AnnualBudgetingMonth;
import dao.orm.AnnualBudgetingMonthId;
import dao.orm.SubjectInfo;
import dao.orm.SysOrg;

public class YearProjectBudgetingServiceTest {
	private static Logger logger = Logger.getLogger(YearProjectBudgetingServiceTest.class);
	private YearProjectBudgetingService yearProjectBudgetingService;
	
	public void saveBudgeting(){
		AnnualBudgetingHeader header = new AnnualBudgetingHeader();
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
		Set<AnnualBudgetingDetail> detailSet = new HashSet<AnnualBudgetingDetail>();
		AnnualBudgetingDetail detail = new AnnualBudgetingDetail();
		detail.setId(4);
		detail.setActivityInfo(new ActivityInfo("B0101"));
		detail.setAmount(new BigDecimal(1000));
		detail.setSubjectInfo(new SubjectInfo("P0101"));
		detail.setHeader(header);
		detailSet.add(detail);
		header.setDetailSet(detailSet);
		Set<AnnualBudgetingMonth> monthSet = new HashSet<AnnualBudgetingMonth>();
		AnnualBudgetingMonth month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(4,1));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(4,2));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(4,3));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(4,4));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		detail.setMonthSet(monthSet);
		yearProjectBudgetingService.saveBudgeting(header);
	}
	
	public void updateBudgeting(){
		AnnualBudgetingHeader header = new AnnualBudgetingHeader();
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
		Set<AnnualBudgetingDetail> detailSet = new HashSet<AnnualBudgetingDetail>();
		AnnualBudgetingDetail detail = new AnnualBudgetingDetail();
		detail.setId(1);
		detail.setActivityInfo(new ActivityInfo("B0101"));
		detail.setAmount(new BigDecimal(1000));
		detail.setSubjectInfo(new SubjectInfo("P0101"));
		detail.setHeader(header);
		detailSet.add(detail);
		header.setDetailSet(detailSet);
		Set<AnnualBudgetingMonth> monthSet = new HashSet<AnnualBudgetingMonth>();
		AnnualBudgetingMonth month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(1,1));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(1,2));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(1,3));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		month = new AnnualBudgetingMonth();
		month.setId(new AnnualBudgetingMonthId(1,4));
		month.setAmount(new BigDecimal(250));
		monthSet.add(month);
		detail.setMonthSet(monthSet);
		yearProjectBudgetingService.updateBudgeting(header);
	}
	
	

	public void getBudgetingById() {
		AnnualBudgetingHeader header = yearProjectBudgetingService.getBudgeting(1);
		Set<AnnualBudgetingDetail> detailSet = header.getDetailSet();
		if(CollectionUtils.isNotEmpty(detailSet)){
			for(AnnualBudgetingDetail detail : detailSet){
				System.out.println(detail.getAmount());
			}
		}
		System.out.println(header);
	}

	public void getBudgetingByProjectCodeAndYear() {
		AnnualBudgetingHeader header = yearProjectBudgetingService.getBudgeting(10000,2014);
		Set<AnnualBudgetingDetail> detailSet = header.getDetailSet();
		if(CollectionUtils.isNotEmpty(detailSet)){
			for(AnnualBudgetingDetail detail : detailSet){
				logger.info("getAmount"+detail.getAmount());
				System.out.println(detail.getActivityInfo().getName());
				System.out.println(detail.getSubjectInfo().getName());
				Set<AnnualBudgetingMonth> monthSet = detail.getMonthSet();
				if(CollectionUtils.isNotEmpty(monthSet)){
					for (AnnualBudgetingMonth month : monthSet) {
						System.out.println(month.getAmount());
					}
				}
			}
		}
		System.out.println(header);
	}

	public void setYearProjectBudgetingService(
			YearProjectBudgetingService yearProjectBudgetingService) {
		this.yearProjectBudgetingService = yearProjectBudgetingService;
	}
	
	public void updateRejectProject(Integer id) {
		this.yearProjectBudgetingService.rejectProject(id);
	}
	
	public void updateSubmitProject(Integer id) {
		this.yearProjectBudgetingService.submitProject(id);
	}
	
	public void getOrgProjectReport(Integer orgId,Integer year){
		List<Map<String,Object>> org = this.yearProjectBudgetingService.getOrgProjectReport(orgId, year);
		System.out.println(org.get(0).get("org_id"));
	}


}
