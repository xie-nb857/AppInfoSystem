package cn.appsys.service.backendimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backen.BackendMapper;
import cn.appsys.dao.backen.DevMapper;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.backend.DevService;

@Service
public class DevServiceImpl implements DevService {

	//注入后台数据访问层对象
	@Resource
	private DevMapper devMapper;
	
	
	@Override
	public DevUser dev(String devCode) {
		return devMapper.getDevByCode(devCode);
	}

}
