package com.rnlic.hraapp.bean.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hrapp_installed_linked_app")
public class InstalledApplicationModal {
	@Id
	private int id;
	
	@ManyToOne
    @JoinColumn(name ="FK_request_id")
	private DeviceRegistrationModal deviceRegistrationModal;
	
	@Column(name="application_name")
	private String applicationName;
	
	@Lob
	@Column(name="application_description")
	private String applicationDescription;
	
	@Column(name="application_version")
	private String applicationVersion;
	
	@Column(name="status_updated_on")
	private String statusUpdatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DeviceRegistrationModal getDeviceRegistrationModal() {
		return deviceRegistrationModal;
	}

	public void setDeviceRegistrationModal(DeviceRegistrationModal deviceRegistrationModal) {
		this.deviceRegistrationModal = deviceRegistrationModal;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public String getStatusUpdatedOn() {
		return statusUpdatedOn;
	}

	public void setStatusUpdatedOn(String statusUpdatedOn) {
		this.statusUpdatedOn = statusUpdatedOn;
	}

	@Override
	public String toString() {
		return "InstalledApplicationModal [id=" + id + ", deviceRegistrationModal=" + deviceRegistrationModal
				+ ", applicationName=" + applicationName + ", applicationDescription=" + applicationDescription
				+ ", applicationVersion=" + applicationVersion + ", statusUpdatedOn=" + statusUpdatedOn + "]";
	}
	

}
