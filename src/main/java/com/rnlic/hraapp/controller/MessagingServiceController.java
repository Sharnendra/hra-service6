package com.rnlic.hraapp.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rnlic.hraapp.bean.OtpDetailsReqBean;
import com.rnlic.hraapp.bean.OtpValidationReqBean;
import com.rnlic.hraapp.bean.rest.response.RestResponse;
import com.rnlic.hraapp.exception.HrAppException;
import com.rnlic.hraapp.exception.UnhandledException;
import com.rnlic.hraapp.inteface.IResponse;
import com.rnlic.hraapp.service.MessagingService;
import com.rnlic.hraapp.util.HrAppUtil;
@RestController
public class MessagingServiceController {
	
private static final org.slf4j.Logger log = LoggerFactory.getLogger(MessagingServiceController.class);
	
	@Autowired
	private MessagingService messageService;
	
	@GetMapping("/getSmS")
	public String startApp(){
		return "APP IS RUNNING!!";
	}
	

	@PostMapping("/generateOTP")
    public @ResponseBody IResponse sendSMSOnPhone(@RequestBody OtpDetailsReqBean otpDetailsReqBean) 
	{
		RestResponse response = new RestResponse(HrAppUtil.generateRequestId());
		try {
			response.setData(messageService.sendSMSOnPhone(otpDetailsReqBean));
		} catch (HrAppException e) {
			// TODO: handle exception
			//log error
			e.printStackTrace();
			response.setError(e);
		}
		catch(Throwable t) {
			//logerror
			t.printStackTrace();
			response.setError(new UnhandledException());
		}
//		return applicationEnablementService.getLinkedAppDetails();
		return response;
    }
	
	
	@RequestMapping(value="/validateOtp",method=RequestMethod.POST)
	public ResponseEntity<String> generateOtp(@RequestBody OtpValidationReqBean otpdetails){
		if(messageService.validateOtp(otpdetails)) {
			return new ResponseEntity<String>("Otp successfully validated!!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Otp is Not valid!!", HttpStatus.BAD_REQUEST);
		}
	}

}
