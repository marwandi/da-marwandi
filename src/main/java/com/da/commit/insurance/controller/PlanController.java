package com.da.commit.insurance.controller;

import com.da.commit.insurance.entity.Plan;
import com.da.commit.insurance.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class is used to receive list plan request
 *
 *
 */
@Slf4j
@RestController
public class PlanController {

    @Autowired
    PlanService planService;

    /**
     * to get all listplant data
     * @return response that store data in the form of plant
     */
    @GetMapping("/listplan")
    public List<Plan> listPlan(){
        return planService.listPlan();
    }

}
