package cn.appsys.service.datadictionary.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backen.datadictionary.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.datadictionary.DataDictionaryService;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Resource
	public DataDictionaryMapper dataDictionaryMapper;
	
	@Override
	public List<DataDictionary> getDataByTypeCode(String typeCode) {
		try {
			return dataDictionaryMapper.getDataByTypeCode(typeCode);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
