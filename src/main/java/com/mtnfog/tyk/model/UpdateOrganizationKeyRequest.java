package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

/**
 * A request to update an organization key.
 * 
 * @author Mountain Fog, Inc.
 *
 */
public class UpdateOrganizationKeyRequest {

	@SerializedName(value="quota_max")
	private int quotaMax;
	
	@SerializedName(value="quota_renews")
	private int quotaRenews;
	
	@SerializedName(value="quota_remaining")
	private int quotaRemaining;
	
	@SerializedName(value="quota_renewal_rate")
	private int quotaRenewalRate;
	
	@SerializedName(value="org_id")
	private String organizationId;
	
	@SerializedName(value="is_inactive")
	private boolean inactive;
	
	public int getQuotaMax() {
		return quotaMax;
	}
	
	public void setQuotaMax(int quotaMax) {
		this.quotaMax = quotaMax;
	}

	public int getQuotaRenews() {
		return quotaRenews;
	}

	public void setQuotaRenews(int quotaRenews) {
		this.quotaRenews = quotaRenews;
	}

	public int getQuotaRemaining() {
		return quotaRemaining;
	}

	public void setQuotaRemaining(int quotaRemaining) {
		this.quotaRemaining = quotaRemaining;
	}

	public int getQuotaRenewalRate() {
		return quotaRenewalRate;
	}

	public void setQuotaRenewalRate(int quotaRenewalRate) {
		this.quotaRenewalRate = quotaRenewalRate;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

}