package cn.appsys.dao.backen.app;

import java.util.List;
import java.util.Map;

import cn.appsys.pojo.AppInfo;

public interface AppMapper {
	//获取app中记录数
	public int getAppCount(AppInfo appInfo);
	
	//获取分页app方法
	public List<AppInfo> getAppByPage(Map<String,Object> map);

	//新增app的方法
	public int add() throws Exception;
}
