package com.mtnfog.tyk.model;

/**
 * A response to create a new API.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class CreateApiDefinitionResponse {

	private String key;
	private String status;
	private String action;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}