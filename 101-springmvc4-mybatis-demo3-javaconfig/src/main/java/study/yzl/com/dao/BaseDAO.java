package study.yzl.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BaseDAO <T , E > {
	
	public long countByExample(E example);

	public int deleteByExample(E example);

	public int deleteByPrimaryKey(Integer id);
	
	public int deleteByIdInBatch(List<Integer> list);

	public int insert(T record);

	public int insertSelective(T record);

	public List<T> selectByExampleWithRowbounds(E example, RowBounds rowBounds);

	public List<T> selectByExample(E example);

	public T selectByPrimaryKey(Integer id);

	public int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

	public int updateByExample(@Param("record") T record, @Param("example") E example);

	public int updateByPrimaryKeySelective(T record);

	public  int updateByPrimaryKey(T record);
	
	
	
	
}