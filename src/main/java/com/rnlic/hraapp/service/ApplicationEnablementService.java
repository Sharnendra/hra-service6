package com.rnlic.hraapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnlic.hraapp.bean.modal.LinkedAppConfigrationModal;
import com.rnlic.hraapp.bean.rest.response.LinkedAppConfig;
import com.rnlic.hraapp.repository.LinkedAppConfigrationRepository;

@Service
public class ApplicationEnablementService {
	
	@Autowired
	private LinkedAppConfigrationRepository linkedAppConfigrationRepository;
	
	public String storeLinkedAppDetails()
	{
		LinkedAppConfigrationModal lm=new LinkedAppConfigrationModal();
		lm.setVersion("12.2v");
		lm.setApplicationDescription("Test");
		lm.setJsonConfig("	[\r\n" + 
				"        {    \r\n" + 
				"            \"groupName\":\"\",\r\n" + 
				"            \"showAsTile\":false,\r\n" + 
				"            \"linkedApps\":\r\n" + 
				"			[\r\n" + 
				"                {\r\n" + 
				"                    \"name\":\"app1\"\r\n" + 
				"                    ,\"description\":\"\"\r\n" + 
				"                    ,\"currentVersion\":\"\"\r\n" + 
				"                    ,\"packageName\":\"\"\r\n" + 
				"                    ,\"icon\":\"\"\r\n" + 
				"                    ,\"flex\" : 1 \r\n" + 
				"                    ,\"link\":\"\"\r\n" + 
				"                    ,\"isApp\":true\r\n" + 
				"                    ,\"applicableFor\":[\"role1\",\"role2\"]\r\n" + 
				"                    ,\"mandatoryFor\":[\"role1\"]\r\n" + 
				"                    ,\"hasInstalled\":false\r\n" + 
				"                    ,\"shouldUpgrade\":true\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        {    \r\n" + 
				"            \"groupName\":\"Communication\",\r\n" + 
				"            \"showAsTile\":true,\r\n" + 
				"            \"linkedApps\":\r\n" + 
				"			[\r\n" + 
				"                {\r\n" + 
				"                    \"name\":\"app2dgdfgdfgdfgdfgdfgdfgkkkkk\"\r\n" + 
				"                    ,\"description\":\"\"\r\n" + 
				"                    ,\"currentVersion\":\"\"\r\n" + 
				"                    ,\"packageName\":\"\"\r\n" + 
				"                    ,\"icon\":\"\"\r\n" + 
				"                    ,\"flex\" : 1 \r\n" + 
				"                    ,\"link\":\"\"\r\n" + 
				"                    ,\"isApp\":true\r\n" + 
				"                    ,\"applicableFor\":[\"role1\",\"role2\"]\r\n" + 
				"                    ,\"mandatoryFor\":[\"role1\"]\r\n" + 
				"                    ,\"hasInstalled\":false\r\n" + 
				"                    ,\"shouldUpgrade\":true\r\n" + 
				"                },\r\n" + 
				"\r\n" + 
				"                {\r\n" + 
				"                    \"name\":\"app2\"\r\n" + 
				"                    ,\"description\":\"\"\r\n" + 
				"                    ,\"currentVersion\":\"\"\r\n" + 
				"                    ,\"packageName\":\"\"\r\n" + 
				"                    ,\"icon\":\"\"\r\n" + 
				"                    ,\"flex\" : 0.5 \r\n" + 
				"                    ,\"link\":\"\"\r\n" + 
				"                    ,\"isApp\":true\r\n" + 
				"                    ,\"applicableFor\":[\"role1\",\"role2\"]\r\n" + 
				"                    ,\"mandatoryFor\":[\"role1\"]\r\n" + 
				"                    ,\"hasInstalled\":false\r\n" + 
				"                    ,\"shouldUpgrade\":true\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"name\":\"app2\"\r\n" + 
				"                    ,\"description\":\"\"\r\n" + 
				"                    ,\"currentVersion\":\"\"\r\n" + 
				"                    ,\"packageName\":\"\"\r\n" + 
				"                    ,\"icon\":\"\"\r\n" + 
				"                    ,\"flex\" : 0.5 \r\n" + 
				"                    ,\"link\":\"\"\r\n" + 
				"                    ,\"isApp\":true\r\n" + 
				"                    ,\"applicableFor\":[\"role1\",\"role2\"]\r\n" + 
				"                    ,\"mandatoryFor\":[\"role1\"]\r\n" + 
				"                    ,\"hasInstalled\":false\r\n" + 
				"                    ,\"shouldUpgrade\":true\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        }\r\n" + 
				"    ]");
		lm.setIsActive('Y');
		linkedAppConfigrationRepository.save(lm);
		return "Called";
	}

	public LinkedAppConfig getLinkedAppDetails() 
	{
		LinkedAppConfig result= null;
//		LinkedAppConfig result= new LinkedAppConfig();
		//LinkedAppConfigrationModal lm=linkedAppConfigrationRepository.getOne(1);
		//update the result object
		result.setDescription("DUMMY");
		result.setJsonConfig("{apps:[{'name':'hello'}]}");
		result.setVersion("v1");
		return result;
	}
}
