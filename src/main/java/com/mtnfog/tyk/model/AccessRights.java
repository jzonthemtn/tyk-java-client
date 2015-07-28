package com.mtnfog.tyk.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AccessRights {

	@SerializedName("api_name")
	private String apiName;
	
	@SerializedName("api_id")
	private String apiId;
	
	public AccessRights() {
		
		versions = new ArrayList<String>();
		
	}
	
	private List<String> versions;

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public List<String> getVersions() {
		return versions;
	}

	public void setVersions(List<String> versions) {
		this.versions = versions;
	}

}