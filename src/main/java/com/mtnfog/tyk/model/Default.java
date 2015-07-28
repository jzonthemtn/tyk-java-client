package com.mtnfog.tyk.model;

import com.google.gson.annotations.Expose;

public class Default {

	@Expose
	private String name;
	
	@Expose
	private String expires;
	
	@Expose
	private Paths paths;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	public Paths getPaths() {
		return paths;
	}

	public void setPaths(Paths paths) {
		this.paths = paths;
	}

}