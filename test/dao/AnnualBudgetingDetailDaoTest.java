package dao;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.orm.AnnualBudgetingDetail;

public class AnnualBudgetingDetailDaoTest {
	private ApplicationContext context;
	private AnnualBudgetingDetailDao dao;
	public AnnualBudgetingDetailDaoTest(){
		 context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 dao = (AnnualBudgetingDetailDao)context.getBean("annualBudgetingDetailDao");
	}
	
	@Test
	public void save(){
		
	}
	
}
