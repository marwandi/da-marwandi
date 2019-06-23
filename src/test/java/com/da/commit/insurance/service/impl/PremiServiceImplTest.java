package com.da.commit.insurance.service.impl;

import com.da.commit.insurance.controller.PremiController;
import com.da.commit.insurance.dto.PremiDTO;
import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.entity.Plan;
import com.da.commit.insurance.entity.User;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.exception.UserNotFoundException;
import com.da.commit.insurance.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PremiServiceImplTest {

    @Autowired
    PremiServiceImpl premiServiceImpl;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    PremiController premiController;

    PremiDTO premiDTO = new PremiDTO();
    User user = new User();
    Plan plan = new Plan();

    @Test
    public void getPremi() throws ParseException, UserNotFoundException , DataNotFoundException {

        premiDTO.setIdPlan(1);
        premiDTO.setIdUser(1);

    String date1 = "1982-02-02";
    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
    Date DOB = format.parse(date1);

    UserDTO userDTO = new UserDTO(2, "marwan","M",DOB,5000000,"+6265634726","2","1",1);

    DecimalFormat df1 = new DecimalFormat("######0.0000");


    Response response = Response.builder()
            .responseCode(HttpStatus.OK.toString())
            .responseMessage("Success")
            .data(df1.format(306000))
            .build();

    Response totalPremi = premiController.premiPage(premiDTO);

    assertEquals(response.getData().toString(), totalPremi.getData().toString());

    }
    @Test(expected = UserNotFoundException.class)
    public void daftarPaket() throws UserNotFoundException{
        premiDTO.setIdPlan(5);
        premiDTO.setIdUser(1);

        premiServiceImpl.getPremi(premiDTO);
    }

    @Test(expected = UserNotFoundException.class)
    public void pekerjaan() throws UserNotFoundException {
        user.setSmokingStatus("8");
        user.setJobType("4");

        premiServiceImpl.jobType(user, plan);

    }

}

