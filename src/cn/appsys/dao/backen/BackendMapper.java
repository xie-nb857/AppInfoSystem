package cn.appsys.dao.backen;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;


public interface BackendMapper {

	//后台管理员登录
	public BackendUser getBackendByCode(@Param("userCode")String userCode);

	
}
