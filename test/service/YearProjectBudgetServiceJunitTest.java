package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YearProjectBudgetServiceJunitTest {
	private static YearProjectBudgetServiceTest yearProjectBudgetServiceTest;
	
	public YearProjectBudgetServiceJunitTest(){
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 yearProjectBudgetServiceTest = (YearProjectBudgetServiceTest)context.getBean("yearProjectBudgetServiceTest");
	}
	@Test
	public void saveBudget(){
		yearProjectBudgetServiceTest.saveBudget();
	}
	
	@Test
	public void getBudgetById(){
		yearProjectBudgetServiceTest.getBudgetById();
	}
	
	@Test
	public void getBudgetByProjectCodeAndYear(){
		yearProjectBudgetServiceTest.getBudgetByProjectCodeAndYear();
	}
	@Test
	public void updateBudgetServiceJunitTest() {
		yearProjectBudgetServiceTest.updateBudget();
	}
	@Test
	public void rejectProject() {
		yearProjectBudgetServiceTest.updateRejectProject(1);
	}
	@Test
	public void submitProject() {
		yearProjectBudgetServiceTest.updateSubmitProject(1);
	}
	@Test
	public void getOrgProjectReport() {
		yearProjectBudgetServiceTest.getOrgProjectReport(1, 2014);
	}
}
