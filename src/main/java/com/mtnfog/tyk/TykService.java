package com.mtnfog.tyk;

import com.mtnfog.tyk.model.ApiDefinition;
import com.mtnfog.tyk.model.CreateApiDefinitionResponse;
import com.mtnfog.tyk.model.CreateOAuthClientResponse;
import com.mtnfog.tyk.model.CreateOrganizationKeyRequest;
import com.mtnfog.tyk.model.CreateOrganizationKeyResponse;
import com.mtnfog.tyk.model.DeleteApiDefinitionResponse;
import com.mtnfog.tyk.model.DeleteOAuthClientResponse;
import com.mtnfog.tyk.model.DeleteOrganizationKeyResponse;
import com.mtnfog.tyk.model.GetKeysResponse;
import com.mtnfog.tyk.model.GetOAuthClientsResponse;
import com.mtnfog.tyk.model.HealthCheckResponse;
import com.mtnfog.tyk.model.HotReloadResponse;
import com.mtnfog.tyk.model.CreateKeyRequest;
import com.mtnfog.tyk.model.CreateKeyResponse;
import com.mtnfog.tyk.model.CreateOAuthClientRequest;
import com.mtnfog.tyk.model.DeleteKeyResponse;
import com.mtnfog.tyk.model.OAuthAuthorizationFlowResponse;
import com.mtnfog.tyk.model.UpdateApiDefinitionResponse;
import com.mtnfog.tyk.model.UpdateOrganizationKeyRequest;
import com.mtnfog.tyk.model.UpdateOrganizationKeyResponse;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * The Tyk 1.7 REST API interface.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public interface TykService {

	// Api Key Management
	
	/**
	 * Creates a new Tyk API key. The created API key will be randomly generated.
	 * @param request A {@link CreateKeyRequest request} containing the details for the new key.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link CreateKeyResponse response} containing the new API key.
	 */
	@POST("/tyk/keys/create/")
	CreateKeyResponse createApiKey(@Body CreateKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Creates a new Tyk API key.
	 * @param apiKey The API key to create.
	 * @param request A {@link CreateKeyRequest request} containing the details for the new key.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link CreateKeyResponse response}.
	 */
	@POST("/tyk/keys/{apiKey}/")
	CreateKeyResponse createApiKey(@Path("apiKey") String apiKey, @Body CreateKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Deletes an API key from Tyk.
	 * @param apiKey The API key to delete.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A link {@link DeleteKeyResponse response}.
	 */
	@DELETE("/tyk/keys/{apiKey}/")
	DeleteKeyResponse deleteApiKey(@Path("apiKey") String apiKey, @Header("x-tyk-authorization") String tykAuthKey);
		
	/**
	 * Get the keys for an API. Note that if Tyk is running in hashed key mode no keys will be returned due
	 * to the encryption of the keys.
	 * @param apiId The ID of the API.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link GetKeysResponse response} containing the API keys.
	 */
	@GET("/tyk/keys/")
	GetKeysResponse getApiKeys(@Query("api_id") String apiId, @Header("x-tyk-authorization") String tykAuthKey);
	
	// API Management
	
	/**
	 * Creates a new API definition.
	 * @param apiDefinition The {@link ApiDefinition definition} of the new API.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link CreateApiDefinitionResponse response}.
	 */
	@POST("/tyk/apis/")
	CreateApiDefinitionResponse createApiDefinition(@Body ApiDefinition apiDefinition, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Updates an API definition.
	 * @param apiId The ID of the API.
	 * @param apiDefinition The updated {@link ApiDefinition definition} of the API.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link UpdateApiDefinitionResponse response}.
	 */
	@PUT("/tyk/apis/{apiId}/")
	UpdateApiDefinitionResponse updateApiDefinition(@Path("apiId") String apiId, @Body ApiDefinition apiDefinition, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Deletes an API.
	 * @param apiId The ID of the API.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link DeleteApiDefinitionResponse response}.
	 */
	@DELETE("/tyk/apis/{apiId}/")
	DeleteApiDefinitionResponse deleteApiDefinition(@Path("apiId") String apiId, @Header("x-tyk-authorization") String tykAuthKey);
	
	// Health Check
	
	/**
	 * Gets the health stats of an API.
	 * @param apiId The ID of the API.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link HealthCheckResponse response} containing the details of the API's health.
	 */
	@GET("/tyk/health/")
	HealthCheckResponse checkHealth(@Query("api_id") String apiId, @Header("x-tyk-authorization") String tykAuthKey);
	
	// Hot Reload
	
	/**
	 * Instruct Tyk to perform a hotreload.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link HotReloadResponse response}.
	 */
	@GET("/tyk/reload/group/")
	HotReloadResponse hotReload(@Header("x-tyk-authorization") String tykAuthKey);
	
	// OAuth Key Management
	
	/**
	 * Creates an OAuth client.
	 * @param request A {@link CreateOAuthClientRequest request}.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link CreateOAuthClientResponse response}.
	 */
	@POST("/tyk/oauth/clients/create/")
	CreateOAuthClientResponse createOAuthClient(@Body CreateOAuthClientRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Deletes an OAuth client.
	 * @param apiId The ID of the API.
	 * @param clientId The ID of the OAuth client.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link DeleteOAuthClientResponse response}.
	 */
	@DELETE("/tyk/oauth/clients/{apiId}/{clientId}/")
	DeleteOAuthClientResponse deleteOAuthClient(@Path("apiId") String apiId, @Path("clientId") String clientId, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Gets the OAuth clients.
	 * @param apiId The ID of the API.
	 * @param clientId The ID of the client.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link GetOAuthClientsResponse response}.
	 */
	@GET("/tyk/oauth/clients/{apiId}/")
	GetOAuthClientsResponse getOAuthClients(@Path("apiId") String apiId, @Path("clientId") String clientId, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Authorizes an OAuth authorization.
	 * @param responseType The type of response.
	 * @param clientId The ID of the client.
	 * @param redirectUri The redirect URI.
	 * @param keyRules The key rules.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link OAuthAuthorizationFlowResponse response}.
	 */
	@FormUrlEncoded
	@POST("/tyk/oauth/authorize-client/")
	OAuthAuthorizationFlowResponse oauthAuthorizationFlow(@Field("response_type") String responseType, @Field("client_id") String clientId, @Field("redirect_uri") String redirectUri, @Field("key_rules") String keyRules, @Header("x-tyk-authorization") String tykAuthKey);
	
	// Organization Keys
	
	/**
	 * Creates an organization key.
	 * @param request A {@link CreateOrganizationKeyRequest request}.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link CreateOrganizationKeyResponse response}.
	 */
	@POST("/tyk/orgs/keys/")
	CreateOrganizationKeyResponse createOrganizationKey(@Body CreateOrganizationKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Updates an organization key.
	 * @param request A {@link UpdateOrganizationKeyRequest request}.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link UpdateOrganizationKeyResponse response}.
	 */
	@POST("/tyk/orgs/keys/{orgId}/")
	UpdateOrganizationKeyResponse updateOrganizationKey(@Body UpdateOrganizationKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Updates an organization key and optionally reset the quota.
	 * @param request A {@link UpdateOrganizationKeyRequest request}.
	 * @param resetQuota Set to 1 to reset the quota.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link UpdateOrganizationKeyResponse response}.
	 */
	@PUT("/tyk/orgs/keys/{orgId}/")
	UpdateOrganizationKeyResponse updateOrganizationKey(@Body UpdateOrganizationKeyRequest request, @Query("reset_quota") int resetQuota, @Header("x-tyk-authorization") String tykAuthKey);
	
	/**
	 * Deletes an organization key.
	 * @param orgId The ID of the organization.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link DeleteOrganizationKeyResponse response}.
	 */
	@DELETE("/tyk/orgs/keys/{orgId}/")
	DeleteOrganizationKeyResponse deleteOrganizationKey(@Path("orgId") String orgId, @Header("x-tyk-authorization") String tykAuthKey);

	/**
	 * Gets the organization keys.
	 * @param tykAuthKey The Tyk authentication key.
	 * @return A {@link GetKeysResponse response}.
	 */
	@GET("/tyk/org/keys/")
	GetKeysResponse getOrganizationKeys(@Header("x-tyk-authorization") String tykAuthKey);

}