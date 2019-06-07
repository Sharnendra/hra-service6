package com.service.messagingservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rnlic.hraapp.bean.OtpResBean;
import com.rnlic.hraapp.controller.MessagingServiceController;
import com.rnlic.hraapp.service.MessagingService;

@RunWith(SpringRunner.class)
@WebMvcTest(MessagingServiceController.class)
@SpringBootTest(classes={MessagingServiceController.class})
public class serviceTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@Test
	public void otpValidation() throws Exception {
		MessagingService messagingService=new MessagingService();
		OtpResBean otpResBean=new OtpResBean();
		otpResBean.setData(true);
		

		String postRequest = "{\"mobile_number\":\"8375939142\",\"message\":\"test\"]}";
		Mockito.when(messagingService.sendSMSOnPhone(Mockito.any())).thenReturn(otpResBean);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/generateOTP")
				.accept(MediaType.APPLICATION_JSON).content(postRequest)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = null;
		result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		

		
	}
}
