package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

/**
 * A response to creating an organization key.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class CreateOrganizationKeyResponse {

	@SerializedName(value="key")
	private String apiKey;
	
	private String status;
	private String action;
	
	@SerializedName(value="is_inactive")
	private boolean inactive;
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	
}