package com.sat.rest.model;

import lombok.Data;

@Data
public class BloodBank {
	
	private int bloodBankId;
	private String bloodBankName;
	private String state;
	private String city;
	private int pincode;
	private long contactNumber;
	private String password;
	
}
