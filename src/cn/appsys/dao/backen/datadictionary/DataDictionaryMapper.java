package cn.appsys.dao.backen.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryMapper {

	//根据状态类型进行查询
	public List<DataDictionary> getDataByTypeCode(@Param("typeCode")String typeCode)throws Exception;
}
