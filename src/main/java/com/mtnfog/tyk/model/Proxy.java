package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class Proxy {

	@SerializedName("listen_path")
	private String listenPath;
	
	@SerializedName("target_url")
	private String targetUrl;
	
	@SerializedName("strip_listen_path")
	private boolean stripListenPath;

	public String getListenPath() {
		return listenPath;
	}

	public void setListenPath(String listenPath) {
		this.listenPath = listenPath;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public boolean isStripListenPath() {
		return stripListenPath;
	}

	public void setStripListenPath(boolean stripListenPath) {
		this.stripListenPath = stripListenPath;
	}

}