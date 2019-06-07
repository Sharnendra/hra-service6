package com.rnlic.hraapp.bean.modal;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hrapp_device_registration")
public class DeviceRegistrationModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="request_id")
	private int requestId;
	
	@Column(name="device_identifier")
	private String deviceIdentifier;
	
	@Column(name="device_type")
	private String deviceType;
	
	@Column(name="sap_code")
	private String sapCode;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="pan_number")
	private String panNumber;
	
	@Column(name="app_version")
	private String appVersion;
	
	@Column(name="registered_on")
	private Boolean registeredOn;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@OneToMany(mappedBy="deviceRegistrationModal", cascade = CascadeType.ALL)
    Collection<InstalledApplicationModal> installedLinkedApps = new ArrayList<InstalledApplicationModal>();

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getDeviceIdentifier() {
		return deviceIdentifier;
	}

	public void setDeviceIdentifier(String deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSapCode() {
		return sapCode;
	}

	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public Boolean getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Boolean registeredOn) {
		this.registeredOn = registeredOn;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Collection<InstalledApplicationModal> getInstalledLinkedApps() {
		return installedLinkedApps;
	}

	public void setInstalledLinkedApps(Collection<InstalledApplicationModal> installedLinkedApps) {
		this.installedLinkedApps = installedLinkedApps;
	}

	@Override
	public String toString() {
		return "DeviceRegistrationModal [requestId=" + requestId + ", deviceIdentifier=" + deviceIdentifier
				+ ", deviceType=" + deviceType + ", sapCode=" + sapCode + ", mobileNumber=" + mobileNumber
				+ ", panNumber=" + panNumber + ", appVersion=" + appVersion + ", registeredOn=" + registeredOn
				+ ", isActive=" + isActive + ", installedLinkedApps=" + installedLinkedApps + "]";
	}
	
	
}
