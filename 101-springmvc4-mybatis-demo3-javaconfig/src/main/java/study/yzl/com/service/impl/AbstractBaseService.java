package study.yzl.com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageRowBounds;

import study.yzl.com.dao.BaseDAO;
import study.yzl.com.model.SysUserExample;
import study.yzl.com.service.BaseService;
import study.yzl.com.web.Page;

public abstract class AbstractBaseService<T,E> implements BaseService<T> {
	
	protected abstract BaseDAO<T, E> getBaseDAO() ;
	
	
	@Override
	@Transactional
	public int create(T entity) {
		
		getBaseDAO().insert(entity);
		return 0;
	}

	@Override
	public int remove(Integer id) {
		return getBaseDAO().deleteByPrimaryKey(id);
		
	}

	@Override
	public int deleteByIdInBatch(List<Integer> list) {
		
		return getBaseDAO().deleteByIdInBatch(list) ;
	}

	@Override
	public int updateById(T entity) {
		 
		return getBaseDAO().updateByPrimaryKey(entity);
	}

	@Override
	public int updateByIdSelective(T entity) {
		return  getBaseDAO().updateByPrimaryKeySelective(entity);
	}

	@Override
	public List<T> queryAllPaged(Page page) {
		  
		PageRowBounds pageRowBounds = new PageRowBounds((page.getPageNo()-1)*page.getPageSize(), page.getPageSize()) ;
		return getBaseDAO().selectByExampleWithRowbounds(null, pageRowBounds);
	}

	@Override
	public T queryById(Integer id) {
		return  getBaseDAO().selectByPrimaryKey(id) ;
	}

}
