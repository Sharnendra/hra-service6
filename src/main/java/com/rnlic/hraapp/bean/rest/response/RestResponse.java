package com.rnlic.hraapp.bean.rest.response;

import com.rnlic.hraapp.exception.HrAppException;
import com.rnlic.hraapp.inteface.IResponse;
import com.rnlic.hraapp.inteface.IResponseData;

public class RestResponse implements IResponse{

	private String requestId;
	private IResponseData data;
	private HrAppException error;
	
	public RestResponse(String requestId) {
		this.requestId = requestId;
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public IResponseData getData() {
		return data;
	}
	public void setData(IResponseData data) {
		this.data = data;
	}
	public HrAppException getError() {
		return error;
	}
	public void setError(HrAppException error) {
		this.error = error;
	}
	
	
}
