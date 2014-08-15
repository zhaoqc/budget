package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YearProjectBudgetingServiceJunitTest {
	private static YearProjectBudgetingServiceTest yearProjectBudgetingServiceTest;
	
	public YearProjectBudgetingServiceJunitTest(){
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 yearProjectBudgetingServiceTest = (YearProjectBudgetingServiceTest)context.getBean("yearProjectBudgetingServiceTest");
	}
	@Test
	public void saveBudgeting(){
		yearProjectBudgetingServiceTest.saveBudgeting();
	}
	
	@Test
	public void getBudgetingById(){
		yearProjectBudgetingServiceTest.getBudgetingById();
	}
	
	@Test
	public void getBudgetingByProjectCodeAndYear(){
		yearProjectBudgetingServiceTest.getBudgetingByProjectCodeAndYear();
	}
	@Test
	public void updateBudgetingServiceJunitTest() {
		yearProjectBudgetingServiceTest.updateBudgeting();
	}
	@Test
	public void rejectProject() {
		yearProjectBudgetingServiceTest.updateRejectProject(1);
	}
	@Test
	public void submitProject() {
		yearProjectBudgetingServiceTest.updateSubmitProject(1);
	}
	@Test
	public void getOrgProjectReport() {
		yearProjectBudgetingServiceTest.getOrgProjectReport(1, 2014);
	}
}
