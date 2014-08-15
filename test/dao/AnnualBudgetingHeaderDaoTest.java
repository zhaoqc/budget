package dao;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.orm.AnnualBudgetingHeader;
import dao.orm.SysOrg;

public class AnnualBudgetingHeaderDaoTest {
	private ApplicationContext context;
	private AnnualBudgetingHeaderDao dao;
	public AnnualBudgetingHeaderDaoTest(){
		 context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 dao = (AnnualBudgetingHeaderDao)context.getBean("annualBudgetingHeaderDao");
	}
	
	@Test
	public void save(){
		AnnualBudgetingHeader header = new AnnualBudgetingHeader();
		header.setSysOrg(new SysOrg(1));
		header.setAmount(new BigDecimal(1000));
		header.setProjectCode(10000);
		header.setProjectName("四川移动招待费");
		header.setStatus(0);
		header.setUserId("10000");
		header.setYear(2014);
		dao.add(header);
		
	}
	
}
