package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class OAuthAuthorizationFlowResponse {

	private String code;
	
	@SerializedName(value="access_token")
	private String accessToken;
	
	@SerializedName(value="expires_in")
	private int expiresIn;
	
	@SerializedName(value="redirect_to")
	private String redirectTo;
	
	@SerializedName(value="token_type")
	private String tokenType;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRedirectTo() {
		return redirectTo;
	}

	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
}