package com.rnlic.hraapp.constant;

import org.springframework.beans.factory.annotation.Value;

public class GenericConstants {
	
	public static final String AUTHORIZATION="Authorization";
	
	@Value("${signinKey}")
	public static String SIGNING_KEY;

}
