package com.cognizant.plans.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PLAN_DETAILS_TAB")
@Data
public class PlanEntity {

	@Id
	@Column(length = 10)
	private String planId;

	@Column(length = 15)
	private String validity;

	@Column(length = 25)
	private String description;
}
