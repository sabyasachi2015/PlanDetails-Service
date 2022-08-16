package com.cognizant.plans.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.plans.api.entity.PlanEntity;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, String> {

}
