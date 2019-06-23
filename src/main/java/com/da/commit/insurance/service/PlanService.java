package com.da.commit.insurance.service;

import com.da.commit.insurance.entity.Plan;

import java.util.List;

/**
 * This class save method used in PlanServiceImpl
 */
@FunctionalInterface
public interface PlanService {

    /**
     * for logic of listplan
     * @return list of all plan
     */
    List<Plan> listPlan();
}
