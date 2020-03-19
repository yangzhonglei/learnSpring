package study.yzl.com.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.yzl.com.dao.SysRoleMenuRelaMapper;
import study.yzl.com.model.SysRoleMenuRela;
import study.yzl.com.model.SysRoleMenuRelaExample;
import study.yzl.com.service.SysRoleMenuRelaService;

@Service
public class SysRoleMenuRelaServiceImpl implements SysRoleMenuRelaService  {

	@Autowired
	private SysRoleMenuRelaMapper sysRoleMenuRelaMapper ;

	@Override
	public long countByExample(SysRoleMenuRelaExample example) {
		return sysRoleMenuRelaMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRoleMenuRelaExample example) {
		return sysRoleMenuRelaMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysRoleMenuRelaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRoleMenuRela record) {
		return sysRoleMenuRelaMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRoleMenuRela record) {
		return sysRoleMenuRelaMapper.insertSelective(record);
	}

	@Override
	public List<SysRoleMenuRela> selectByExampleWithRowbounds(SysRoleMenuRelaExample example, RowBounds rowBounds) {
		return sysRoleMenuRelaMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public List<SysRoleMenuRela> selectByExample(SysRoleMenuRelaExample example) {
		return sysRoleMenuRelaMapper.selectByExample(example);
	}

	@Override
	public SysRoleMenuRela selectByPrimaryKey(Integer id) {
		return sysRoleMenuRelaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysRoleMenuRela record, SysRoleMenuRelaExample example) {
		return sysRoleMenuRelaMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRoleMenuRela record, SysRoleMenuRelaExample example) {
		return sysRoleMenuRelaMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRoleMenuRela record) {
		return sysRoleMenuRelaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRoleMenuRela record) {
		return sysRoleMenuRelaMapper.updateByPrimaryKey(record);
	}
	
	
	
	
	
}
