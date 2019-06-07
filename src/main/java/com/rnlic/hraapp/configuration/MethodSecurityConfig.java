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

import com.rnlic.hraapp.bean.MethodAuthorizationBean;

@Configuration
@ConfigurationProperties(prefix="methodsecurity")
@EnableConfigurationProperties
@Component
public class MethodSecurityConfig implements InitializingBean{

	private List<MethodAuthorizationBean> securitymap = new ArrayList<MethodAuthorizationBean>();
	private Map<String,List<String>> roleBasedSecurity = new HashMap<String,List<String>>();
	private String secret;
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public List<MethodAuthorizationBean> getSecuritymap() {
		return securitymap;
	}
	
	public void setSecuritymap(List<MethodAuthorizationBean> securitymap) {
		this.securitymap = securitymap;
	}
	
	public Map<String, List<String>> getRoleBasedSecurity() {
		return roleBasedSecurity;
	}
	
	public void setRoleBasedSecurity(Map<String, List<String>> roleBasedSecurity) {
		this.roleBasedSecurity = roleBasedSecurity;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.err.println(toString());
		
		setRoleBasedSecurity(securitymap.stream()
						.collect(
						   Collectors.toMap(MethodAuthorizationBean::getServiceId,MethodAuthorizationBean::getRolesAllowed)
						));
	}

	@Override
	public String toString() {
		return "MethodSecurityConfig [securitymap=" + securitymap + ", roleBasedSecurity=" + roleBasedSecurity
				+ ", secret=" + secret + "]";
	}
	
	
}
