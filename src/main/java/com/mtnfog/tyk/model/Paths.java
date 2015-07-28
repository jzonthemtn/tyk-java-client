package com.mtnfog.tyk.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Paths {

	private List<Object> ignored;
	
	@SerializedName("white_list")
	private List<Object> whiteList;
	
	@SerializedName("black_list")
	private List<Object> blackList;

	public Paths() {
		
		ignored = new ArrayList<Object>();
		whiteList = new ArrayList<Object>();
		blackList = new ArrayList<Object>();
		 
	}
	
	public List<Object> getIgnored() {
		return ignored;
	}

	public void setIgnored(List<Object> ignored) {
		this.ignored = ignored;
	}

	public List<Object> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(List<Object> whiteList) {
		this.whiteList = whiteList;
	}

	public List<Object> getBlackList() {
		return blackList;
	}

	public void setBlackList(List<Object> blackList) {
		this.blackList = blackList;
	}

}