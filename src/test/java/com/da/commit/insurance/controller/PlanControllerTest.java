package com.da.commit.insurance.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PlanControllerTest {

    @Autowired
    PlanController PlanController;

    @Test
    public void listPlan() {
        assertNotNull(PlanController.listPlan());
    }

}
