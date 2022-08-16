package com.cognizant.plans.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.plans.api.model.Plan;
import com.cognizant.plans.api.service.IPlansService;

@RequestMapping("/api/v1/plan")
@RestController
public class PlansRestController {
	
  @Autowired
  private IPlansService plansService;
	
  @GetMapping("/viewPlans")
  public ResponseEntity<? extends Object> viewAllPlans(){
	  
	//call service layer		
	List<Plan> fetchPlansList = plansService.fetchPlans();
	if(!fetchPlansList.isEmpty()) {
			
		return new ResponseEntity<List<Plan>>(fetchPlansList, HttpStatus.OK);
	}else {
	    return new ResponseEntity<Object>("No Plans were Found in the DB", HttpStatus.BAD_REQUEST);
	}		
  }

  @GetMapping("/viewPlans/{planId}")
  public ResponseEntity<? extends Object> fetchSpecificPlan(@PathVariable String planId){
	 
	//call service layer
	 Plan plan = plansService.fetchSpecificPlan(planId);
		if(plan != null) {
			return new ResponseEntity<Plan>(plan, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(String.format("No plan exists with : %s", planId), HttpStatus.BAD_REQUEST);
		}
	 }	
  }
	

