package com.yzl.study.spingboot.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;


public interface BaseService <T> {
	
	 /**增
	 * @param entity
	 * @return
	 */
	 public int  create(T entity);
	
	 /**增
	  * @param entity
	  * @return
	  */
	 public int  createBatch(List<T> entityList);
	 
	 
	 
	 /** 根据id删除
	 * @param id
	 */
	public int remove(Integer id);
	
	 /**根据id 的list   批量删除
	 * @param list
	 * @return
	 */
	public int  deleteByIdInBatch(List<Integer> list);
	 
	
	/**根据id更新 
	 * @param entity
	 */
	public int  updateById(T entity);
	
	/**根据id更新  只更新参数对象非空字段
	 * @param entity
	 */
	public int  updateByIdSelective(T entity);
	
	 /**分页查询
	 * @param query
	 * @param page
	 * @return
	 */
//	public List<T> queryPageList(T query, Page  page);
	 
	/**根据id 查询
	 * @param id
	 * @return
	 */
	public T  queryById(Integer id);

	
//	List<T> queryAllPaged(Page page);
	 
}
