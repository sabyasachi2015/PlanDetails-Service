package com.cognizant.plans.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.plans.api.entity.PlanEntity;
import com.cognizant.plans.api.model.Plan;
import com.cognizant.plans.api.repository.PlanRepository;
import com.cognizant.plans.api.service.IPlansService;

@Service
public class PlanServiceImpl implements IPlansService {
	
	@Autowired
	private PlanRepository planRepository;

	@Override
	public List<Plan> fetchPlans() {
		//call repository layer		
		List<PlanEntity> listPlanEntity = planRepository.findAll();
		List<Plan> listPlanDto= new ArrayList<>();
		
		listPlanEntity.forEach(planEntity ->{
			
			Plan planDto = new Plan();
			BeanUtils.copyProperties(planEntity, planDto);
			listPlanDto.add(planDto);			
		});		
		return listPlanDto;
	}

	@Override
	public Plan fetchSpecificPlan(String planId) {
		//call repository layer
		Optional<PlanEntity> optPlanEntity = planRepository.findById(planId);
		if(optPlanEntity.isPresent()) {
			
			PlanEntity planEntity = optPlanEntity.get();
			Plan plan=new Plan();
			BeanUtils.copyProperties(planEntity, plan);
			return plan;
		}		
		return null;
	}
}
















