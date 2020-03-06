package cn.appsys.service.backendimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backen.BackendMapper;
import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendService;

@Service
public class BackendServiceImpl implements BackendService {
	
	//注入后台数据访问层对象
	@Resource
	private BackendMapper backendMapper;
	
	
	@Override
	public BackendUser login(String userCode) {
		return backendMapper.getBackendByCode(userCode);
	}

}
