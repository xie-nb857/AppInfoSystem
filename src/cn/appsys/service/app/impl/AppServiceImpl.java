package cn.appsys.service.app.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backen.app.AppMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.service.app.AppService;

@Service
public class AppServiceImpl implements AppService {

	@Resource
	private AppMapper appMapper;
	
	@Override
	public int getAppCount(AppInfo appInfo) {
		return appMapper.getAppCount(appInfo);
	}

	@Override
	public List<AppInfo> getAppByPage(Map<String,Object> map) {
		return appMapper.getAppByPage(map);
	}

}
