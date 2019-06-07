package com.rnlic.hraapp.bean.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="hrapp_linked_application_cofig")
public class LinkedAppConfigrationModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="version")
	private String version;
	
	@Column(name="application_description")
	private String applicationDescription;
	
	@Column(name="is_active")
	private char isActive;
	
	@Lob
	@Column(name="json_config")
	private String jsonConfig;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public String getJsonConfig() {
		return jsonConfig;
	}

	public void setJsonConfig(String jsonConfig) {
		this.jsonConfig = jsonConfig;
	}

	@Override
	public String toString() {
		return "{ version=" + version + ", description="
				+ applicationDescription + ", isActive=" + isActive + ", linkedApplications=" + jsonConfig + "}";
	}

}
