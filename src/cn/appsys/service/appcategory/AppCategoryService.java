package cn.appsys.service.appcategory;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryService {

	public List<AppCategory> getAppCategoryListByParentId(Integer parentId);
}
