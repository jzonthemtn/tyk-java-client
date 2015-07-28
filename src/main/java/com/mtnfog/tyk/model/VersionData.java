package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class VersionData {

	@SerializedName("not_versioned")
	private boolean notVersioned;
	
	private Versions versions;

	public boolean isNotVersioned() {
		return notVersioned;
	}

	public void setNotVersioned(boolean notVersioned) {
		this.notVersioned = notVersioned;
	}

	public Versions getVersions() {
		return versions;
	}

	public void setVersions(Versions versions) {
		this.versions = versions;
	}

}