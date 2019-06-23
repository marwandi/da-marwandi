package com.da.commit.insurance.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PremiTest {

    @Test
    public void testPremi() {
        Integer idUser = 1;
        Integer idPaket = 1;

        BigDecimal jumlahPremi = new BigDecimal(306000);

        Premi premi = new Premi();
        premi.setIdUser(idUser);
        premi.setIdPlan(idPaket);
        premi.setTotalPremi(jumlahPremi);


        assertEquals(idUser, premi.getIdPlan());
        assertEquals(idPaket, premi.getIdPlan());
        assertEquals(jumlahPremi, premi.getTotalPremi());


    }
}
