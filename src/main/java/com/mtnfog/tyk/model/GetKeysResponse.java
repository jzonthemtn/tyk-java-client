package com.mtnfog.tyk.model;

import java.util.List;

/**
 * A response to a request to get all API keys.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class GetKeysResponse {

	private List<String> keys;

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
}