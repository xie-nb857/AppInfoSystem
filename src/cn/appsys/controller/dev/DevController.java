package cn.appsys.controller.dev;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;







import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.app.AppService;
import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.backend.DevService;
import cn.appsys.service.datadictionary.DataDictionaryService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@Controller
@RequestMapping("/dev/flatform")
public class DevController {
	
	@Resource
	private DevService devService;
	
	@Resource
	private AppService appService;
	
	@Resource
	private DataDictionaryService dataDictionaryMapper;
	
	@Resource
	private AppCategoryService appCategoryMapper;
	
	
	//查询app信息，进入app列表，展示内容
	/**
	 * 参数列表中可能存在
	 * currentPageNo:当前页码数--->pageIndex
	 * softwareName:软件名称---> querySoftwareName
	 * status:软件状态---> queryStatus
	 * flatformId:所属平台id--->queryFlatformId
	 * categoryLevel1:所属一级分类ID--->queryCategoryLevel1
	 * categoryLevel2:所属二级分类--->queryCategoryLevel2
	 * categoryLevel3:所属三级分类--->queryCategoryLevel3 
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("/app/list")
	public String appList(@RequestParam(value="querySoftwareName",required=false)String softwareName,
			@RequestParam(value="pageIndex",required=false)String currentPageNo,
			@RequestParam(value="queryStatus",required=false)String status,
			@RequestParam(value="queryFlatformId",required=false)String flatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)String categoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)String categoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)String categoryLevel3,
			Model model,HttpRequest request){
		//定义几个需要在页面中展示的数据列表
		//一级分类集合
		List<AppCategory> categoryLevel1List=null;
		//二级分类集合
		List<AppCategory> categoryLevel2List=null;
		//三级分类集合
		List<AppCategory> categoryLevel3List=null;
		//app状态的集合
		List<DataDictionary> statusList=null;
		//所属平台集合
		List<DataDictionary> flatFormList=null;
		
		
		//应该用于接收和页码的变量
		Integer _currentPageNo=null;
		Integer _status=null;
		Integer _flatformId=null;
		Integer _CategoryLevel1=null;
		Integer _CategoryLevel2=null;
		Integer _CategoryLevel3=null;
		//将当前页码数转换为int类型
		if(currentPageNo==null){
			_currentPageNo=Integer.parseInt(currentPageNo);
		}else{
			_currentPageNo=1;
		}
		//判断状态
		if(status==null){
			_status=Integer.parseInt(status);
		}
		//下列情况不需要设置默认值，如果为空，不会产生对应的sql语句
		//判断类型
		if(flatformId==null){
			_flatformId=Integer.parseInt(flatformId);
		}
		//判断一级分类
		if(categoryLevel1==null){
			_CategoryLevel1=Integer.parseInt(categoryLevel1);
		}
		//判断二级分类
		if(categoryLevel2==null){
			_CategoryLevel2=Integer.parseInt(categoryLevel2);
		}
		//判断三级分类
		if(categoryLevel3==null){
			_CategoryLevel3=Integer.parseInt(categoryLevel3);
		}
		
		//查询集合
		statusList = dataDictionaryMapper.getDataByTypeCode("APP_STATUS");
		flatFormList = dataDictionaryMapper.getDataByTypeCode("APP_FLATFORM");
		categoryLevel1List = appCategoryMapper.getAppCategoryListByParentId(null);
		categoryLevel1List = appCategoryMapper.getAppCategoryListByParentId(_CategoryLevel1);
		categoryLevel1List = appCategoryMapper.getAppCategoryListByParentId(_CategoryLevel2);
		
		
		
		
		//填充数据
		AppInfo appInfo = new AppInfo();
		appInfo.setSoftwareName(softwareName);
		appInfo.setStatus(_status);
		appInfo.setFlatformId(_flatformId);
		appInfo.setCategoryLevel1(_CategoryLevel1);
		appInfo.setCategoryLevel2(_CategoryLevel2);
		appInfo.setCategoryLevel3(_CategoryLevel3);
		//分页查询：1.计算总的一个记录数 
		int count = appService.getAppCount(appInfo);
		//2.获取对应页面数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appInfo", appInfo);
		map.put("start", _currentPageNo-1);
		map.put("", Constants.pageSize);
		List<AppInfo> list=appService.getAppByPage(map);
		//创建工具类对象，放入数据
		PageSupport pages = new PageSupport();
		//设置当前页面数
		pages.setCurrentPageNo(_currentPageNo);
		//设置页面容量
		pages.setPageSize(Constants.pageSize);
		//设置查询的中记录数
		pages.setTotalCount(count);
		
		//将数据保存在Model中返回页面
		model.addAttribute("appInfoList", list);
		model.addAttribute("pages", pages);
		model.addAttribute("statusList",statusList);
		model.addAttribute("flatFromList",flatFormList);
		model.addAttribute("categoryLevel1List",categoryLevel1List);
		model.addAttribute("categoryLevel2List",categoryLevel2List);
		model.addAttribute("categoryLevel3List",categoryLevel3List);
		return "developer/appinfolist";
	}
}
