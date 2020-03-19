package study.yzl.com.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.yzl.com.dao.SysUserRoleRelaMapper;
import study.yzl.com.model.SysUserRoleRela;
import study.yzl.com.model.SysUserRoleRelaExample;
import study.yzl.com.service.SysUserRoleRelaService;

@Service
public class SysUserRoleRelaServiceImpl implements SysUserRoleRelaService  {
	
	
	@Autowired
	private  SysUserRoleRelaMapper sysUserRoleRelaMapper ;

	@Override
	public long countByExample(SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysUserRoleRelaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.insertSelective(record);
	}

	@Override
	public List<SysUserRoleRela> selectByExampleWithRowbounds(SysUserRoleRelaExample example, RowBounds rowBounds) {
		return sysUserRoleRelaMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public List<SysUserRoleRela> selectByExample(SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.selectByExample(example);
	}

	@Override
	public SysUserRoleRela selectByPrimaryKey(Integer id) {
		return sysUserRoleRelaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysUserRoleRela record, SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysUserRoleRela record, SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.updateByPrimaryKey(record);
	}
	
	
	
	

}
