package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class CreateOrganizationKeyRequest {

	private int allowance;	
	private int rate;
	private int per;
	private int expires;
	
	@SerializedName("quota_max")
	private int quotaMax;
	
	private int quotaRenews;
	
	@SerializedName("quota_remaining")
	private int quotaRemaining;
	
	@SerializedName("quota_renewal_rate")
	private int quotaRenewalRate;
	
	@SerializedName("access_rights")
	private AccessRights accessRights;
	
	@SerializedName("org_id")
	private String orgId;

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}

	public int getExpires() {
		return expires;
	}

	public void setExpires(int expires) {
		this.expires = expires;
	}

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

	public AccessRights getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(AccessRights accessRights) {
		this.accessRights = accessRights;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}