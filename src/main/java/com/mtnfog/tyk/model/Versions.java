package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class Versions {

	@SerializedName(value="Default")
	private Default defaultVersion;

	public Default getDefault() {
		return defaultVersion;
	}

	public void setDefault(Default defaultVersion) {
		this.defaultVersion = defaultVersion;
	}

}