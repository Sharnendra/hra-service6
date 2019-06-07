package com.rnlic.hraapp.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.rnlic.hraapp.bean.OtpDetailsReqBean;
import com.rnlic.hraapp.bean.OtpResBean;
import com.rnlic.hraapp.bean.OtpValidationReqBean;
import com.rnlic.hraapp.bean.modal.OtpMasterModal;
import com.rnlic.hraapp.configuration.MessagingConfig;
import com.rnlic.hraapp.repository.OTP_intefarce;
import com.rnlic.hraapp.repository.OtpRepository;

@Service
public class MessagingService implements OTP_intefarce{
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(MessagingService.class);
	@Autowired
	private MessagingConfig smsConfig;
	
	@Autowired
	private OtpRepository otpRepo;
	private OtpMasterModal otpEntity;
	
	public OtpResBean sendSMSOnPhone(OtpDetailsReqBean otpDetailsReqBean) throws RestClientException, IOException {
		
		//SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
		//Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.cognizant.com", 6050));
		//clientHttpReq.setProxy(proxy);
		//RestTemplate restTemplate = new RestTemplate(clientHttpReq);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		OtpResBean otpResBean=new OtpResBean();
		
		if(saveOTP(otpDetailsReqBean))
		{
			String Api= "http://api.textlocal.in/send/?" 
					+ "apikey=" + URLEncoder.encode(smsConfig.getApiKey(), "UTF-8") 
					+ "&numbers=" + URLEncoder.encode(otpDetailsReqBean.getMobile_number(), "UTF-8") 
					+ "&message=" + URLEncoder.encode("Your OTP is "+otpEntity.getOtpValue()+"!! Please do not share with anyone else.", "UTF-8");
			response=restTemplate.exchange(Api,HttpMethod.GET, getHeaders(),String.class);
			otpResBean.setData(true);
		}
		else
		{
			otpResBean.setData(false);
		}
		
//		if(saveOTP(otpDetailsReqBean))
//		{
//			log.info("=================in sendSMSOnPhone line 1 ==============");
//			try {
//				// Send data
//				String Api= "http://api.textlocal.in/send/?" 
//				+ "apikey=" + URLEncoder.encode(smsConfig.getApiKey(), "UTF-8") 
//				+ "&numbers=" + URLEncoder.encode(otpDetailsReqBean.getMobile_number(), "UTF-8") 
//				+ "&message=" + URLEncoder.encode("Your OTP is "+otpEntity.getOtpValue()+"!! Please do not share with anyone else.", "UTF-8");
//			} catch (Exception e) {
//				System.out.println("Error SMS "+e);
//				return "Error "+e;
//			}
//		}
//		else
//		{
//			throw new RuntimeException("ERROR OCCURED WHILE GENERATING OTP!!");
//		}
		return otpResBean;
	}
	
	private boolean saveOTP(OtpDetailsReqBean otpDetailsReqBean) {
		log.info("=================in saveOTP line 1 ==============");
		OtpMasterModal otpEntity= new OtpMasterModal();
		//otpEntity.setSapCode(otpDetailsReqBean.getSap_code());
		otpEntity.setOtpValue(getOpt());
		otpEntity.setMobileNumber(otpDetailsReqBean.getMobile_number());
		//otpEntity.setDeviceIdentifier(otpDetailsReqBean.getUuid());
		otpEntity.setGeneratedOn(new Date());
		otpEntity.setValidUpto(new Date(System.currentTimeMillis()+5*60*1000));
		log.info("=================in saveOTP line 2 ==============");
		if(otpRepo.save(otpEntity)!=null) {
			log.info("=================in saveOTP line 3 ==============");
			this.otpEntity=otpEntity;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validateOtp(OtpValidationReqBean otpdetails) {
		OtpMasterModal otpEntity=otpRepo.findByUserId(otpdetails.getUuid(),otpdetails.getOtpValue());
		if(otpEntity!=null) {
			if (otpdetails.getOtpValue()==otpEntity.getOtpValue()) {
				System.err.println("df d "+otpdetails.getOtpValue());
				System.err.println("dfd "+otpEntity.getOtpValue());
				return true;
			}
		}
		return false;
	}
	
	private static org.springframework.http.HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new org.springframework.http.HttpEntity<>(headers);
	}
}
