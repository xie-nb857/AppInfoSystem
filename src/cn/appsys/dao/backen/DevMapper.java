package cn.appsys.dao.backen;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevMapper {
    //开发者登录信息获取
	public DevUser getDevByCode(@Param("devCode")String devCode);
}
