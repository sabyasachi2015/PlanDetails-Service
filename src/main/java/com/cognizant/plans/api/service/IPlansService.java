package com.cognizant.plans.api.service;

import java.util.List;

import com.cognizant.plans.api.model.Plan;

public interface IPlansService {
	
	public List<Plan> fetchPlans();
	
	public Plan fetchSpecificPlan(String planId);

}
