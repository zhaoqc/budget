package dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.orm.SysUser;
import dao.orm.TableIds;

public class TableIdsDaoTest {
	
	private TableIdsDao tableIdsDao;
	
	public TableIdsDaoTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		tableIdsDao = (TableIdsDao)context.getBean("tableIdsDao");
	}
	
	@Test
	public void save(){
		TableIds tableIds = new TableIds();
		tableIds.setSysUser(new SysUser("1"));
		tableIds.setTableName("budget_company_reserve");
		tableIds.setEntryDatetime(new Date());
		tableIds.setTableMaxId(1);
		tableIdsDao.add(tableIds);
	}
	
	@Test
	public void getMaxId(){
		Integer maxId = tableIdsDao.getNextId("budgeting_project", "1");
		System.out.println(maxId);
	}
	
}
