package com.rnlic.hraapp.bean.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hrapp_otp")
public class OtpMasterModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="otp_id")
	private long otpId;
	
	@Column(name="sap_code")
	private String sapCode;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="device_identifier")
	private String deviceIdentifier;
	
	@Column(name="OTP_VALUE")
	private int otpValue;
	
	@Column(name="generated_on")
	private Date generatedOn;
	
	@Column(name="valid_upto")
	private Date validUpto;
	
	@Column(name="retry_count")
	private int retryCount;

	public long getOtpId() {
		return otpId;
	}

	public void setOtpId(long otpId) {
		this.otpId = otpId;
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

	public String getDeviceIdentifier() {
		return deviceIdentifier;
	}

	public void setDeviceIdentifier(String deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
	}

	public int getOtpValue() {
		return otpValue;
	}

	public void setOtpValue(int otpValue) {
		this.otpValue = otpValue;
	}

	public Date getGeneratedOn() {
		return generatedOn;
	}

	public void setGeneratedOn(Date generatedOn) {
		this.generatedOn = generatedOn;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	@Override
	public String toString() {
		return "OtpMasterModal [otpId=" + otpId + ", sapCode=" + sapCode + ", mobileNumber=" + mobileNumber
				+ ", deviceIdentifier=" + deviceIdentifier + ", otpValue=" + otpValue + ", generatedOn=" + generatedOn
				+ ", validUpto=" + validUpto + ", retryCount=" + retryCount + "]";
	}

	

}
