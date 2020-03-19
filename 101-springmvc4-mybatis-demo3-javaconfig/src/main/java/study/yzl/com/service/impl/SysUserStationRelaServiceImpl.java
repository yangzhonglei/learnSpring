package study.yzl.com.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.yzl.com.dao.SysUserStationRelaMapper;
import study.yzl.com.model.SysUserStationRela;
import study.yzl.com.model.SysUserStationRelaExample;
import study.yzl.com.service.SysUserStationRelaService;
@Service
public class SysUserStationRelaServiceImpl implements SysUserStationRelaService {
	
	@Autowired
	private SysUserStationRelaMapper  SysUserStationRelaMapper ;

	@Override
	public long countByExample(SysUserStationRelaExample example) {
		return SysUserStationRelaMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysUserStationRelaExample example) {
		return SysUserStationRelaMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SysUserStationRelaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUserStationRela record) {
		return SysUserStationRelaMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUserStationRela record) {
		return SysUserStationRelaMapper.insertSelective(record);
	}

	@Override
	public List<SysUserStationRela> selectByExampleWithRowbounds(SysUserStationRelaExample example,
			RowBounds rowBounds) {
		return SysUserStationRelaMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public List<SysUserStationRela> selectByExample(SysUserStationRelaExample example) {
		return SysUserStationRelaMapper.selectByExample(example);
	}

	@Override
	public SysUserStationRela selectByPrimaryKey(Integer id) {
		return SysUserStationRelaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysUserStationRela record, SysUserStationRelaExample example) {
		return SysUserStationRelaMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysUserStationRela record, SysUserStationRelaExample example) {
		return SysUserStationRelaMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserStationRela record) {
		return SysUserStationRelaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUserStationRela record) {
		return SysUserStationRelaMapper.updateByPrimaryKey(record);
	}
	
	

}
