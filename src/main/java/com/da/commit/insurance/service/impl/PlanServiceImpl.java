package com.da.commit.insurance.service.impl;


import com.da.commit.insurance.entity.Plan;
import com.da.commit.insurance.repository.PlanRepository;
import com.da.commit.insurance.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is to process PlanService related to request from PlanController
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    public List<Plan> listPlan() { return planRepository.findAll();}
}
