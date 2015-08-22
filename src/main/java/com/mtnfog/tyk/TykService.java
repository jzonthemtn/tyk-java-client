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
	
	@POST("/tyk/keys/create/")
	CreateKeyResponse createApiKey(@Body CreateKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	@POST("/tyk/keys/{apiKey}/")
	CreateKeyResponse createApiKey(@Path("apiKey") String apiKey, @Body CreateKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
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
	
	@POST("/tyk/apis/")
	CreateApiDefinitionResponse createApiDefinition(@Body ApiDefinition apiDefinition, @Header("x-tyk-authorization") String tykAuthKey);
	
	@PUT("/tyk/apis/{apiId}/")
	UpdateApiDefinitionResponse updateApiDefinition(@Path("apiId") String apiId, @Body ApiDefinition apiDefinition, @Header("x-tyk-authorization") String tykAuthKey);
	
	@DELETE("/tyk/apis/{apiId}/")
	DeleteApiDefinitionResponse deleteApiDefinition(@Path("apiId") String apiId, @Header("x-tyk-authorization") String tykAuthKey);
	
	// Health Check
	
	@GET("/tyk/health/")
	HealthCheckResponse checkHealth(@Query("api_id") String apiId, @Header("x-tyk-authorization") String tykAuthKey);
	
	// Hot Reload
	
	@GET("/tyk/reload/group/")
	HotReloadResponse hotReload(@Header("x-tyk-authorization") String tykAuthKey);
	
	// OAuth Key Management
	
	@POST("/tyk/oauth/clients/create/")
	CreateOAuthClientResponse createOAuthClient(@Body CreateOAuthClientRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	@DELETE("/tyk/oauth/clients/{apiId}/{clientId}/")
	DeleteOAuthClientResponse deleteOAuthClient(@Path("apiId") String apiId, @Path("clientId") String clientId, @Header("x-tyk-authorization") String tykAuthKey);
	
	@GET("/tyk/oauth/clients/{apiId}/")
	GetOAuthClientsResponse getOAuthClients(@Path("apiId") String apiId, @Path("clientId") String clientId, @Header("x-tyk-authorization") String tykAuthKey);
	
	@FormUrlEncoded
	@POST("/tyk/oauth/authorize-client/")
	OAuthAuthorizationFlowResponse oauthAuthorizationFlow(@Field("response_type") String responseType, @Field("client_id") String clientId, @Field("redirect_uri") String redirectUri, @Field("key_rules") String keyRules, @Header("x-tyk-authorization") String tykAuthKey);
	
	// Organization Keys
	
	@POST("/tyk/orgs/keys/")
	CreateOrganizationKeyResponse createOrganizationKey(@Body CreateOrganizationKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	@POST("/tyk/orgs/keys/{orgId}/")
	UpdateOrganizationKeyResponse updateOrganizationKey(@Body UpdateOrganizationKeyRequest request, @Header("x-tyk-authorization") String tykAuthKey);
	
	@PUT("/tyk/orgs/keys/{orgId}/")
	UpdateOrganizationKeyResponse updateOrganizationKey(@Body UpdateOrganizationKeyRequest request, @Query("reset_quota") int resetQuota, @Header("x-tyk-authorization") String tykAuthKey);
	
	@DELETE("/tyk/orgs/keys/{orgId}/")
	DeleteOrganizationKeyResponse deleteOrganizationKey(@Path("orgId") String orgId, @Header("x-tyk-authorization") String tykAuthKey);

	@GET("/tyk/org/keys/")
	GetKeysResponse getOrganizationKeys(@Header("x-tyk-authorization") String tykAuthKey);

}