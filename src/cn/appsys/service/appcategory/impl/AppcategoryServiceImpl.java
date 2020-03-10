package cn.appsys.service.appcategory.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backen.appcategory.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.service.appcategory.AppCategoryService;

@Service
public class AppcategoryServiceImpl implements AppCategoryService {

	private AppCategoryMapper appCategoryMapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId) {
		try {
			return appCategoryMapper.getAppCategoryListByParentId(parentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
