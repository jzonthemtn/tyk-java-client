package com.mtnfog.tyk;

import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.mtnfog.tyk.model.CreateKeyRequest;
import com.mtnfog.tyk.model.CreateKeyResponse;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class TykClient  {
   
	private TykService tykService;
	private String tykAuthKey;
	
	public TykClient(String tykEndpoint, String tykAuthKey) {
		
		final OkHttpClient okHttpClient = new OkHttpClient();
	    okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
	    okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);

	    Gson gson = new Gson();
	    
	    RestAdapter restAdapter = new RestAdapter.Builder()
	        .setEndpoint(tykEndpoint)
	        .setConverter(new GsonConverter(gson))
	        .setClient(new OkClient(okHttpClient))
	        .build();
	    
	    tykService = restAdapter.create(TykService.class);
	    this.tykAuthKey = tykAuthKey;
	    
	}
	
	public CreateKeyResponse createApiKey(String apiKey, CreateKeyRequest request) {
		
		return tykService.createApiKey(apiKey, request, tykAuthKey);		
		
	}
	
}