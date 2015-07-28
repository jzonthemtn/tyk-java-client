package com.mtnfog.tyk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A response to a request to get OAuth clients.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class GetOAuthClientsResponse {

	private List<OAuthClient> oauthClients;

	public GetOAuthClientsResponse() {
		oauthClients = new ArrayList<OAuthClient>();
	}
	
	public List<OAuthClient> getOauthClients() {
		return oauthClients;
	}

	public void setOauthClients(List<OAuthClient> oauthClients) {
		this.oauthClients = oauthClients;
	}
	
}