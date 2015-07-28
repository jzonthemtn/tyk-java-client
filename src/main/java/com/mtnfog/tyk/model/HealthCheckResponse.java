package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

/**
 * A response to a health check request.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class HealthCheckResponse {

	@SerializedName(value="throttle_requests_per_second")
	private int throttleRequestsPerSecond;
	
	@SerializedName(value="quota_violations_per_second")
	private int quotaViolationsPerSecond;
	
	@SerializedName(value="key_failures_per_second")
	private int keyFailuresPerSecond;
	
	@SerializedName(value="average_upstream_latency")	
	private int averageUpstreamLatency;
	
	@SerializedName(value="average_requests_per_second")
	private int averageRequestsPerSecond;
	
	public int getThrottleRequestsPerSecond() {
		return throttleRequestsPerSecond;
	}
	
	public void setThrottleRequestsPerSecond(int throttleRequestsPerSecond) {
		this.throttleRequestsPerSecond = throttleRequestsPerSecond;
	}

	public int getQuotaViolationsPerSecond() {
		return quotaViolationsPerSecond;
	}

	public void setQuotaViolationsPerSecond(int quotaViolationsPerSecond) {
		this.quotaViolationsPerSecond = quotaViolationsPerSecond;
	}

	public int getKeyFailuresPerSecond() {
		return keyFailuresPerSecond;
	}

	public void setKeyFailuresPerSecond(int keyFailuresPerSecond) {
		this.keyFailuresPerSecond = keyFailuresPerSecond;
	}

	public int getAverageUpstreamLatency() {
		return averageUpstreamLatency;
	}

	public void setAverageUpstreamLatency(int averageUpstreamLatency) {
		this.averageUpstreamLatency = averageUpstreamLatency;
	}

	public int getAverageRequestsPerSecond() {
		return averageRequestsPerSecond;
	}

	public void setAverageRequestsPerSecond(int averageRequestsPerSecond) {
		this.averageRequestsPerSecond = averageRequestsPerSecond;
	}

}