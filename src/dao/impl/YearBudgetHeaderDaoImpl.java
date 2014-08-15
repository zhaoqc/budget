package dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import dao.YearBudgetHeaderDao;
import dao.orm.YearBudgetHeader;

public class YearBudgetHeaderDaoImpl extends BaseDaoImpl<YearBudgetHeader> implements YearBudgetHeaderDao{

	@Override
	public List<Map<String, Object>> getReport(final String sql, final Map<String,Object> params) {
		return super.getHibernateTemplate().executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				 Query query =  session.createSQLQuery(sql).setProperties(params);
				 return (List)query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();  
			}
			
		});
	}
}
