package org.binggo.mockapp.common;

public enum ResponseCode {
	
	OK (0, "ok"),
	FAILURE (1, "fail"),
	MISSING_FIELDS (2, "some fields are missing"),
	INVALID_PARAMETER (3, "some parameters are invalid");
	
	private final int retCode;
	private final String retMsg;
	
	private ResponseCode(int retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public int getRetCode() {
		return retCode;
	}
	
	public String getRetMsg() {
		return retMsg;
	}
	
}
