package study.yzl.com.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import study.yzl.com.model.Station;
import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysMenuExample;

public interface SysMenuService  extends BaseService <SysMenu>{

	List<SysMenu> selectByExample(SysMenuExample example);


}