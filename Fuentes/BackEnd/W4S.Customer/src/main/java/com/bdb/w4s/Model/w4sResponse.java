package com.bdb.w4s.Model;

public class w4sResponse {

	private String code;
	
	private String type;
	
	private Object entity;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}
	  
	
	public w4sResponse getResponse()
	{
		
		return this;
		
	}
}
