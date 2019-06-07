package com.rnlic.hraapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rnlic.hraapp.bean.rest.response.RestResponse;
import com.rnlic.hraapp.exception.HrAppException;
import com.rnlic.hraapp.exception.UnhandledException;
import com.rnlic.hraapp.inteface.IResponse;
import com.rnlic.hraapp.service.ApplicationEnablementService;
import com.rnlic.hraapp.util.HrAppUtil;

@RestController
@RequestMapping("/service")
public class ApplicationEnablementController {
	
	@Autowired
	private ApplicationEnablementService applicationEnablementService;
	
//	@GetMapping("/store")
//	public String save()
//	{
//		return applicationEnablementService.storeLinkedAppDetails();
//	}
	
	@GetMapping("/retrieve")
	public @ResponseBody IResponse load()
	{
		RestResponse response = new RestResponse(HrAppUtil.generateRequestId());
		try {
			response.setData(applicationEnablementService.getLinkedAppDetails());
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
}
