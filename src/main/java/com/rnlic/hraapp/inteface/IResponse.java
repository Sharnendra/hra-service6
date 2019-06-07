package com.rnlic.hraapp.inteface;

import com.rnlic.hraapp.exception.HrAppException;

public interface IResponse {
	String getRequestId();
	IResponseData getData();
	HrAppException getError();
}
