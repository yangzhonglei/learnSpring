package study.yzl.com.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study.yzl.com.dao.SysLoginAcctMapper;
import study.yzl.com.model.SysLoginAcct;
import study.yzl.com.model.SysLoginAcctExample;
import study.yzl.com.model.SysUser;
import study.yzl.com.service.SysLogAcctService;
import study.yzl.com.service.SysUserService;

@Service
public class SysLoginAcctServiceImpl implements SysLogAcctService {
	
	@Autowired
	private SysUserService sysUserService ;
	
	@Autowired
	private  SysLoginAcctMapper sysLoginAcctMapper ;

	@Override
	public long countByExample(SysLoginAcctExample example) {
		return sysLoginAcctMapper.countByExample(example);
	}
    @Override
	@Transactional
	public int deleteByExample(SysLoginAcctExample example) {
		return sysLoginAcctMapper.deleteByExample(example);
	}
    @Override
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return sysLoginAcctMapper.deleteByPrimaryKey(id);
	}
    @Override
	@Transactional
	public int insert(SysLoginAcct record) {
		return sysLoginAcctMapper.insert(record);
	}
    @Override
	@Transactional
	public int insertSelective(SysLoginAcct record) {
		return sysLoginAcctMapper.insertSelective(record);
	}

	@Override
	public List<SysLoginAcct> selectByExampleWithRowbounds(SysLoginAcctExample example, RowBounds rowBounds) {
		return sysLoginAcctMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public List<SysLoginAcct> selectByExample(SysLoginAcctExample example) {
		return sysLoginAcctMapper.selectByExample(example);
	}

	@Override
	public SysLoginAcct selectByPrimaryKey(Integer id) {
		return sysLoginAcctMapper.selectByPrimaryKey(id);
	}
	 @Override
	@Transactional
	public int updateByExampleSelective(SysLoginAcct record, SysLoginAcctExample example) {
		return sysLoginAcctMapper.updateByExampleSelective(record, example);
	}
	 @Override
	@Transactional
	public int updateByExample(SysLoginAcct record, SysLoginAcctExample example) {
		return sysLoginAcctMapper.updateByExample(record, example);
	}
	 @Override
	@Transactional
	public int updateByPrimaryKeySelective(SysLoginAcct record) {
		return sysLoginAcctMapper.updateByPrimaryKeySelective(record);
	}
	 @Override
	@Transactional
	public int updateByPrimaryKey(SysLoginAcct record) {
		return sysLoginAcctMapper.updateByPrimaryKey(record);
	}
	 
	 
	@Override
	public SysLoginAcct login(SysLoginAcct acct) {
		
		SysLoginAcctExample example = new SysLoginAcctExample();
		example.createCriteria().andAcctEqualTo(acct.getAcct()).andStatusEqualTo(0);
		List<SysLoginAcct> acctList = sysLoginAcctMapper.selectByExample(example);
		if(acctList!=null && acctList.size()==1 && acctList.get(0).checkPassword(acct.getPassword())) {
			return acctList.get(0);
		}
		return null;
	}


	
	

}
