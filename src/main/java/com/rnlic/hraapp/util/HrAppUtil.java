package com.rnlic.hraapp.util;

import java.util.UUID;

public abstract class HrAppUtil {

	public static String generateRequestId() {
		return UUID.randomUUID().toString();
	}
}
