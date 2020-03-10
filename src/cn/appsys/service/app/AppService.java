package cn.appsys.service.app;

import java.util.List;


import java.util.Map;

import cn.appsys.pojo.AppInfo;

public interface AppService {

	//获取总记录数
	public int getAppCount(AppInfo appInfo);
	
	//分页查询
	public List<AppInfo> getAppByPage(Map<String, Object> map);
}
