package study.yzl.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import study.yzl.com.model.Station;
import study.yzl.com.model.StationExample;
import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysMenuExample;

public interface SysMenuMapper  extends BaseDAO <SysMenu , SysMenuExample >{
    
}