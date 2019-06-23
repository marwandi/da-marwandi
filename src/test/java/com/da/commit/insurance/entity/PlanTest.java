package com.da.commit.insurance.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PlanTest {

    @Test
    public void testplan() {
        Integer idPlan = 1;

        String name = "marwan";

        BigDecimal price = new BigDecimal(500000);

        String description = "warlock";

        Integer minAge = 17;

        Integer minIncome = 7000000;

        Plan plan = new Plan();
        plan.setIdPlan(idPlan);
        plan.setPrice(price);
        plan.setDescription(description);
        plan.setMinIncome(minIncome);
        plan.setMinAge(minAge);
        plan.setName(name);

        assertEquals(idPlan, plan.getIdPlan());
        assertEquals(name, plan.getName());
        assertEquals(price, plan.getPrice());
        assertEquals(description, plan.getDescription());
        assertEquals(minAge, plan.getMinAge());
        assertEquals(minIncome, plan.getMinIncome());

    }
}
