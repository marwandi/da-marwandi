package com.da.commit.insurance.controller;

import com.da.commit.insurance.dto.PremiDTO;
import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.entity.Plan;
import com.da.commit.insurance.entity.User;
import com.da.commit.insurance.entity.Premi;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.exception.UserNotFoundException;
import com.da.commit.insurance.service.impl.PremiServiceImpl;
import com.da.commit.insurance.service.impl.UserServiceImpl;
import com.da.commit.insurance.util.Response;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PremiControllerTest {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    PremiServiceImpl premiServiceImpl;

    @Autowired
    PremiController premiController;

    Response response = Response.builder().build();
    PremiDTO premiDTO = new PremiDTO();
    User user = new User();
    Plan plan = new Plan();

    @Test
    public void premiPage()throws ParseException, DataNotFoundException, UserNotFoundException {

        premiDTO.setIdPlan(1);
        premiDTO.setIdUser(1);

        String date1 = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date1);


        UserDTO userDTO = new UserDTO(2, "marwan","M",DOB,5000000,"+62821321321","2","1",1);


        Response user = premiController.premiPage(premiDTO);
        DecimalFormat df1 = new DecimalFormat("######0.0000");

        response.setData(df1.format(306000));
        response.setResponseCode("200 OK");
        response.setResponseMessage("Success");
        response.setResponseCode(HttpStatus.OK.toString());

        Response totalPremi = premiServiceImpl.getPremi(premiDTO);
        totalPremi.setResponseMessage("Success");
        totalPremi.setResponseCode(HttpStatus.OK.toString());

        assertEquals(response.getData().toString(), totalPremi.getData().toString());
    }

    @Test(expected = UserNotFoundException.class)
    public void listPlan() throws UserNotFoundException{
        premiDTO.setIdPlan(5);
        premiDTO.setIdUser(1);

        premiServiceImpl.getPremi(premiDTO);
    }

    @Test(expected = UserNotFoundException.class)
    public void jobType() throws UserNotFoundException{
        user.setSmokingStatus("8");
        user.setJobType("4");

        premiServiceImpl.jobType(user,plan);
    }
}
