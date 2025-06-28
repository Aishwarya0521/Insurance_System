package com.hexaware.insurance.entity;

public class Policy {

	private int policyId;
	private String policyName;
	private String policyType;
	private String premium;
	
	public Policy() {
		
	}

	public Policy(int policyId, String policyName, String policyType, String premium) {
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyType = policyType;
		this.premium = premium;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		
		return "Policy: [PolicyId = " + policyId + ", policyName = " + policyName + ", policyType = " 
		+ policyType+ ", premium = " + premium + "]\n"; 
	}

	
}