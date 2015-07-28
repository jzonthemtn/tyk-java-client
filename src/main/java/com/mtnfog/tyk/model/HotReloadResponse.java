package com.mtnfog.tyk.model;

/**
 * A response to a hot reload request.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class HotReloadResponse {

	private String status;
	private String error;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}