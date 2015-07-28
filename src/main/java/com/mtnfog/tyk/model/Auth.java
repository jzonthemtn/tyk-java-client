package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class Auth {

	@SerializedName("auth_header_name")
	private String authHeaderName;

	public String getAuthHeaderName() {
		return authHeaderName;
	}

	public void setAuthHeaderName(String authHeaderName) {
		this.authHeaderName = authHeaderName;
	}

}