package com.da.commit.insurance.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PlanServiceImplTest {
    @Autowired
    PlanServiceImpl planServiceImpl;

    @Test
    public void listPlan() { assertNotNull(planServiceImpl.planRepository.findAll());
    }
}
