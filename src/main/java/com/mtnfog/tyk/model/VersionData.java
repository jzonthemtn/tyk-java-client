package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class VersionData {

	@SerializedName("not_versioned")
	private boolean notVersioned;
	
	private Versions versions;

	/**
	 * 
	 * @return The notVersioned
	 */
	public boolean isNotVersioned() {
		return notVersioned;
	}

	/**
	 * 
	 * @param notVersioned
	 *            The not_versioned
	 */
	public void setNotVersioned(boolean notVersioned) {
		this.notVersioned = notVersioned;
	}

	/**
	 * 
	 * @return The versions
	 */
	public Versions getVersions() {
		return versions;
	}

	/**
	 * 
	 * @param versions
	 *            The versions
	 */
	public void setVersions(Versions versions) {
		this.versions = versions;
	}

}