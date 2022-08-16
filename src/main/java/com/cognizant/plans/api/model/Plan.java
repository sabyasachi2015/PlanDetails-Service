package com.cognizant.plans.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	private String planId;

	private String validity;

	private String description;
	
}
