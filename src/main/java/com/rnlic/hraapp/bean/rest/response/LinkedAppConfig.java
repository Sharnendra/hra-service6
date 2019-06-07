package com.rnlic.hraapp.bean.rest.response;

import com.rnlic.hraapp.inteface.IResponseData;

public class LinkedAppConfig implements IResponseData{
	
	private String version;
	private String description;
	private String jsonConfig;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJsonConfig() {
		return jsonConfig;
	}
	public void setJsonConfig(String jsonConfig) {
		this.jsonConfig = jsonConfig;
	}
	
	

}
