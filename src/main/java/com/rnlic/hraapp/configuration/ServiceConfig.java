package com.rnlic.hraapp.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.rnlic.hraapp.bean.CommonConfigurationBean;
import com.rnlic.hraapp.bean.ServiceBasedConfigurationBean;

@Configuration
@ConfigurationProperties(prefix="service")
@EnableConfigurationProperties
@Component
public class ServiceConfig implements InitializingBean{

	private String serviceTypeHeader;
	private List<ServiceBasedConfigurationBean> servicemap = new ArrayList<ServiceBasedConfigurationBean>();
	private Map<String,CommonConfigurationBean> servicemapper = new HashMap<String,CommonConfigurationBean>();
	
	public Map<String, CommonConfigurationBean> getServicemapper() {
		return servicemapper;
	}

	public void setServicemapper(Map<String, CommonConfigurationBean> servicemapper) {
		this.servicemapper = servicemapper;
	}

	public String getServiceTypeHeader() {
		return serviceTypeHeader;
	}

	public void setServiceTypeHeader(String serviceTypeHeader) {
		this.serviceTypeHeader = serviceTypeHeader;
	}

	public List<ServiceBasedConfigurationBean> getServicemap() {
		return servicemap;
	}

	public void setServicemap(List<ServiceBasedConfigurationBean> servicemap) {
		this.servicemap = servicemap;
	}
	
	@Override
	public String toString() {
		return "ConfigService [serviceTypeHeader=" + serviceTypeHeader + ", servicemap=" + servicemap + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.err.println(toString());
		
		setServicemapper(servicemap.stream()
						.collect(
						   Collectors.toMap(ServiceBasedConfigurationBean::getServicename,ServiceBasedConfigurationBean::getCommonConfigurations)
						));
	}
}
