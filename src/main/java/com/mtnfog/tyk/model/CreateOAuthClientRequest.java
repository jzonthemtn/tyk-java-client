package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

/**
 * A request to create an OAuth client.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class CreateOAuthClientRequest {

	@SerializedName(value="app_id")
	private String appId;
	
	@SerializedName(value="redirect_uri")
	private String redirectUri;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	

}