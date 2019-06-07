package com.rnlic.hraapp.bean;

public class ServiceBasedConfigurationBean{
	
	private String servicename;
	private CommonConfigurationBean commonConfigurations;
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public CommonConfigurationBean getCommonConfigurations() {
		return commonConfigurations;
	}
	public void setCommonConfigurations(CommonConfigurationBean commonConfigurations) {
		this.commonConfigurations = commonConfigurations;
	}
	@Override
	public String toString() {
		return "ServiceBasedConfig [servicename=" + servicename + ", commonConfigurations=" + commonConfigurations + "]";
	}
}
