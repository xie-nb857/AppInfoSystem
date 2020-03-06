package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BackendService {
	public BackendUser login(String userCode);
}
