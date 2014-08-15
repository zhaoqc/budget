package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BaseDao;

/**
 * 此类具有BaseDao<T> 的所有方法，为的是减少代码量
 * 建议在dao层接口的实现类继承自这个类，这样可以减少很多代码
 * 如果继承这个类不能满足相关的需求，那么你就可以重写你想扩展的那个方法。
 * @author STARTNEW2009
 * 
 * @param <T>
 *            泛型
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	@SuppressWarnings("unchecked")
	private Class cls;
	
	public BaseDaoImpl(){
		Type genType = getClass().getGenericSuperclass();   
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();   
		cls =  (Class)params[0];   
	}
	
	
	/**
	 * 增加一个实体对象
	 * 
	 * @param entity
	 */
	public void add(T entity) {
		super.getHibernateTemplate().save(entity);
	}

	/**
	 * 删除一个对象
	 * @param entity
	 */
	public void delete(T entity) {
		super.getHibernateTemplate().delete(entity);
	}
	
	public void delete(Serializable id){
		T entity = this.get(id);
		this.delete(entity);
	}

	/**
	 * 修改一个实体对象
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		super.getHibernateTemplate().update(entity);
	}

	/**
	 * 根据主键查询一个对象
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) super.getHibernateTemplate().get(cls, id);
	}
	
	@SuppressWarnings("unchecked")
	public T load(Serializable id){
		return (T)super.getHibernateTemplate().load(cls, id);
	}

	/**
	 * 根据hql查询对象的集合
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> searchByHql(String hql, Object[] values) {
		return super.getHibernateTemplate().find(hql, values);
	}

	/**
	 * 根据hql查询对象的集合并分页
	 * 
	 * @param hql
	 * @param values
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            当前页的数量
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> searchByHql(final String hql, final Object[] values,
			final int page, final int pageSize) {
		return super.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						int firstResult = (page - 1) * pageSize;
						Query query = session.createQuery(hql).setFirstResult(
								firstResult).setMaxResults(pageSize);
						if (values != null && values.length > 0) {
							for (int i = 0; i < values.length; i++) {
								query.setString(i, values[i].toString());
							}
						}
						return query.list();
					}

				});
	}
	
	@SuppressWarnings("unchecked")
	public List<T> searchByHql(final String hql,  final Map<String,Object> params){
		return super.getHibernateTemplate().executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(hql).setProperties(params).list();
			}
			
		});
	}
}
