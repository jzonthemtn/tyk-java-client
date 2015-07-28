package com.mtnfog.tyk.model;

import com.google.gson.annotations.SerializedName;

public class CreateKeyRequest {

	private int allowance;
	private int rate;
	private int per;
	private int expires;
	
	@SerializedName(value="quota_renews")
	private int quotaRenews;
	
	@SerializedName(value="quota_remaining")
	private int quotaRemaining;
	
	@SerializedName(value="quota_renewalrate")
	private int quotaRenewalRate;
	
	@SerializedName(value="access_rights")
	private AccessRights accessRights;
	
	@SerializedName(value="org_id")
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
}