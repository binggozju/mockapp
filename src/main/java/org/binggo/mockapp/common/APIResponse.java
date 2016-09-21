package org.binggo.mockapp.common;

public class APIResponse {
	private Integer retCode;
	
	private String retMessage;
	
	private Object result;

	public APIResponse(ResponseCode rc, Object result) {
		this.retCode = rc.getRetCode();
		this.retMessage = rc.getRetMsg();
		this.result = result;
	}
	
	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
