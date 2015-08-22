package com.mtnfog.tyk;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.mtnfog.tyk.model.ApiDefinition;
import com.mtnfog.tyk.model.CreateApiDefinitionResponse;
import com.mtnfog.tyk.model.CreateKeyRequest;
import com.mtnfog.tyk.model.CreateKeyResponse;
import com.mtnfog.tyk.model.CreateOAuthClientRequest;
import com.mtnfog.tyk.model.CreateOAuthClientResponse;
import com.mtnfog.tyk.model.CreateOrganizationKeyRequest;
import com.mtnfog.tyk.model.CreateOrganizationKeyResponse;
import com.mtnfog.tyk.model.DeleteApiDefinitionResponse;
import com.mtnfog.tyk.model.DeleteKeyResponse;
import com.mtnfog.tyk.model.DeleteOAuthClientResponse;
import com.mtnfog.tyk.model.DeleteOrganizationKeyResponse;
import com.mtnfog.tyk.model.GetKeysResponse;
import com.mtnfog.tyk.model.GetOAuthClientsResponse;
import com.mtnfog.tyk.model.HealthCheckResponse;
import com.mtnfog.tyk.model.HotReloadResponse;
import com.mtnfog.tyk.model.OAuthAuthorizationFlowResponse;
import com.mtnfog.tyk.model.UpdateApiDefinitionResponse;
import com.mtnfog.tyk.model.UpdateOrganizationKeyRequest;
import com.mtnfog.tyk.model.UpdateOrganizationKeyResponse;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * A client implementation of the Tyk 1.7 REST API.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class TykClient  {
	
	private static final Logger LOGGER = LogManager.getLogger(TykClient.class);
   
	private TykService tykService;
	private String tykAuthKey;
	
	/**
	 * Creates a new client with default timeouts of 60 seconds.
	 * @param tykEndpoint The Tyk endpoint.
	 * @param tykAuthKey The Tyk authorization key.
	 */
	public TykClient(String tykEndpoint, String tykAuthKey) {
		
		this(tykEndpoint, tykAuthKey, 60, 60);
			    
	}
	
	/**
	 * Creates a new client.
	 * @param tykEndpoint The Tyk endpoint.
	 * @param tykAuthKey The Tyk authorization key.
	 * @param readTimeout The read timeout in seconds.
	 * @param connectTimeout The connect timeout in seconds.
	 */
	public TykClient(String tykEndpoint, String tykAuthKey, int readTimeout, int connectTimeout) {
		
		final OkHttpClient okHttpClient = new OkHttpClient();
	    okHttpClient.setReadTimeout(readTimeout, TimeUnit.SECONDS);
	    okHttpClient.setConnectTimeout(connectTimeout, TimeUnit.SECONDS);

	    Gson gson = new Gson();
	    
	    RestAdapter restAdapter = new RestAdapter.Builder()
	        .setEndpoint(tykEndpoint)
	        .setConverter(new GsonConverter(gson))
	        .setClient(new OkClient(okHttpClient))
	        .build();
	    
	    tykService = restAdapter.create(TykService.class);
	    
	    this.tykAuthKey = tykAuthKey;
	    
	}
	
	/**
	 * Creates a new API key.
	 * @param request The {@link CreateKeyRequest request}.
	 * @return A {@link CreateKeyResponse response} containing the new API key.
	 */
	public CreateKeyResponse createApiKey(CreateKeyRequest request) {
		
		return tykService.createApiKey(request, tykAuthKey);		
		
	}	
	
	/**
	 * Creates a new API key.
	 * @param apiKey The new API key.
	 * @param request The {@link CreateKeyRequest request}.
	 * @return A {@link CreateKeyResponse response} containing the new key.
	 */
	public CreateKeyResponse createApiKey(String apiKey, CreateKeyRequest request) {
		
		return tykService.createApiKey(apiKey, request, tykAuthKey);		
		
	}
	
	/**
	 * Deletes an API key.
	 * @param apiKey The API key to delete.
	 * @return A {@link DeleteKeyResponse response}.
	 */
	public DeleteKeyResponse deleteApiKey(String apiKey) {
		
		return tykService.deleteApiKey(apiKey, tykAuthKey);
		
	}
		
	/**
	 * Gets all API keys for an API.
	 * @param apiId The ID of the API.
	 * @return A {@link GetKeysResponse response} containing the API keys.
	 */
	public GetKeysResponse getApiKeys(String apiId) {
		
		return tykService.getApiKeys(apiId, tykAuthKey);
		
	}
	
	/**
	 * Creates a new API.
	 * @param apiDefinition The {@link ApiDefinition definition} of the new API.
	 * @return A {@link CreateApiDefinitionResponse response}.
	 */
	public CreateApiDefinitionResponse createApiDefinition(ApiDefinition apiDefinition) {
		
		return tykService.createApiDefinition(apiDefinition, tykAuthKey);
		
	}
	
	/**
	 * Updates a API.
	 * @param apiId The ID of the API.
	 * @param apiDefinition The {@link ApiDefinition definition} of the updated API.
	 * @return A {@link UpdateApiDefinitionResponse response}.
	 */
	public UpdateApiDefinitionResponse updateApiDefinition(String apiId, ApiDefinition apiDefinition) {
		
		return tykService.updateApiDefinition(apiId, apiDefinition, tykAuthKey);
		
	}
	
	/**
	 * Deletes an API.
	 * @param apiId The ID of the API to delete.
	 * @return A {@link DeleteApiDefinitionResponse response}.
	 */
	public DeleteApiDefinitionResponse deleteApiDefinition(String apiId) {
		
		return tykService.deleteApiDefinition(apiId, tykAuthKey);
		
	}
	
	/**
	 * Checks the health of an API.
	 * @param apiId The ID of the API.
	 * @return A {@link HealthCheckResponse response}.
	 */
	public HealthCheckResponse checkHealth(String apiId) {
		
		return tykService.checkHealth(apiId, tykAuthKey);
		
	}
	
	/**
	 * Initiates a hot reload.
	 * @return A {@link HotReloadResponse response}.
	 */
	public HotReloadResponse hotReload() {
		
		return tykService.hotReload(tykAuthKey);
		
	}
	
	/**
	 * Creates a new OAuth client.
	 * @param request The {@link CreateOAuthClientRequest request}.
	 * @return A {@link CreateOAuthClientResponse response}.
	 */
	public CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest request) {
		
		return tykService.createOAuthClient(request, tykAuthKey);
		
	}
	
	/**
	 * Deletes an OAuth client.
	 * @param apiId The ID of the API.
	 * @param clientId The ID of the client.
	 * @return A {@link DeleteOAuthClientResponse response} response.
	 */
	public DeleteOAuthClientResponse deleteOAuthClient(String apiId, String clientId) {
		
		return tykService.deleteOAuthClient(apiId, clientId, tykAuthKey);
		
	}
	
	/**
	 * Gets the OAuth clients.
	 * @param apiId The ID of the API.
	 * @param clientId The ID of the client.
	 * @return A {@link GetOAuthClientsResponse response}.
	 */
	public GetOAuthClientsResponse getOAuthClients(String apiId, String clientId) {
		
		return tykService.getOAuthClients(apiId, clientId, tykAuthKey);
		
	}
	
	/**
	 * Authorizes an OAuth flow.
	 * @param responseType The type of the response.
	 * @param clientId The ID of the client.
	 * @param redirectUri The redirect URI.
	 * @param keyRules The key rules.
	 * @return A {@link OAuthAuthorizationFlowResponse response}.
	 */
	public OAuthAuthorizationFlowResponse oauthAuthorizationFlow(String responseType, String clientId, String redirectUri, String keyRules) {
		
		// TODO: Make responseType an enum.
		return tykService.oauthAuthorizationFlow(responseType, clientId, redirectUri, keyRules, tykAuthKey);
		
	}
	
	/**
	 * Creates an organization key.
	 * @param request A {@link CreateOrganizationKeyRequest request}.
	 * @return A {@link CreateOrganizationKeyResponse response}.
	 */
	public CreateOrganizationKeyResponse createOrganizationKey(CreateOrganizationKeyRequest request) {
		
		return tykService.createOrganizationKey(request, tykAuthKey);
		
	}
	
	/**
	 * Updates an organization key.
	 * @param request A {@link UpdateOrganizationKeyRequest request}.
	 * @return A {@link UpdateOrganizationKeyResponse response}.
	 */
	public UpdateOrganizationKeyResponse updateOrganizationKey(UpdateOrganizationKeyRequest request) {
		
		return tykService.updateOrganizationKey(request, tykAuthKey);
		
	}
	
	/**
	 * Updates an organization key.
	 * @param request A {@link UpdateOrganizationKeyRequest request}.
	 * @param resetQuota Set to <code>true</code> to reset the organization's quota.
	 * @return A {@link UpdateOrganizationKeyResponse response}.
	 */
	public UpdateOrganizationKeyResponse updateOrganizationKey(UpdateOrganizationKeyRequest request, boolean resetQuota) {
		
		int reset = 0;
		
		if(resetQuota) {
			reset = 1;
		}
		
		return tykService.updateOrganizationKey(request, reset, tykAuthKey);
		
	}
	
	/**
	 * Deletes an organization key.
	 * @param organizationId The ID of the organization.
	 * @return A {@link DeleteOrganizationKeyResponse response}.
	 */
	public DeleteOrganizationKeyResponse deleteOrganizationKey(String organizationId) {
		
		return tykService.deleteOrganizationKey(organizationId, tykAuthKey);
		
	}
	
	/**
	 * Gets all organization keys.
	 * @return A {@link GetKeysResponse response} containing the organization keys.
	 */
	public GetKeysResponse getOrganizationKeys() {
		
		return tykService.getOrganizationKeys(tykAuthKey);
		
	}
	
}