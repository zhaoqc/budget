package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 所有数据访问的超接口 这里具有基本的增删改查
 * 
 * @author STARTNEW2009
 * 
 * @param <T>
 *            泛型
 */
public interface BaseDao<T> {
	/**
	 * 增加一个对象
	 * 
	 * @param entity
	 */
	public void add(T entity);


	/**
	 * 根据对象删除
	 * 
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 根据主键id删除一个对象
	 * @param id
	 */
	public void delete(Serializable id);

	/**
	 * 修改一个对象
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 根据id查询一个对象
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Serializable id);

	/**
	 * 根据id查询对象 没找到对象抛出异常
	 * @param id
	 * @return
	 */
	public T load(Serializable id);
	
	/**
	 * 根据hql查询对象的集合
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<T> searchByHql(String hql, Object[] values);
	

	/**
	 * 根据hql查询对象的集合 分页查询
	 * 
	 * @param hql
	 * @param values
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            当前页最多显示的条数
	 * @return
	 */
	public List<T> searchByHql(String hql, Object[] values, int page,
			int pageSize);
	
	public List<T> searchByHql(String hql, Map<String,Object> params);
	
}
