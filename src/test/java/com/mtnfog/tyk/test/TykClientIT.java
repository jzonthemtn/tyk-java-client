package com.mtnfog.tyk.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.mtnfog.tyk.TykClient;
import com.mtnfog.tyk.model.GetKeysResponse;
import com.mtnfog.tyk.model.HealthCheckResponse;

/**
 * Integration tests for {@link TykClient}.
 * @author Mountain Fog, Inc.
 *
 */
public class TykClientIT {

	private static final Logger LOGGER = LogManager.getLogger(TykClientIT.class);
	
	final String tykEndpoint = "your-tyk-endpoint";
	final String tykAuthKey = "your-tyk-auth-key";
	final String apiId = "your-api-id";
	
	@Test
	public void getApiKeys() {
		
		TykClient tykClient = new TykClient(tykEndpoint, tykAuthKey);
		GetKeysResponse response = tykClient.getApiKeys(apiId);
		
		LOGGER.info("Retrieved {} keys.", response.getKeys().size());
		
		for(String key : response.getKeys()) {
			LOGGER.info("Key: {}", key);
		}
		
	}
	
	@Test
	public void checkHealth() {
		
		TykClient tykClient = new TykClient(tykEndpoint, tykAuthKey);
		HealthCheckResponse response = tykClient.checkHealth(apiId);
		
		LOGGER.info(response.getAverageRequestsPerSecond());
		LOGGER.info(response.getAverageUpstreamLatency());
		LOGGER.info(response.getKeyFailuresPerSecond());
		LOGGER.info(response.getQuotaViolationsPerSecond());
		LOGGER.info(response.getThrottleRequestsPerSecond());
		
	}
	
}