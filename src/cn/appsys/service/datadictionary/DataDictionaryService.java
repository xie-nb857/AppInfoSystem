package cn.appsys.service.datadictionary;

import java.util.List;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryService {

	//根据typeCode查询数据字典
	public List<DataDictionary> getDataByTypeCode(String typeCode);
}
