package com.da.commit.insurance.service.impl;

import com.da.commit.insurance.controller.ExceptionHandlingController;
import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.util.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    ExceptionHandlingController exceptionHandlingController;

    @Test
    public void packetFunction() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);

        UserDTO userDTOAct = new UserDTO(3,"marwan","M",DOB,5000000,"+6281281626729","1","1",1);

        Response responseExpected = Response.builder()
                .data(userDTOAct)
                .build();

        UserDTO userDTOExp = new UserDTO(3,"marwan","M",DOB,5000000,"+6281281626728","1","1",1);


        Response responseActual = userServiceImpl.packetFunction(userDTOAct);

        assertEquals(responseExpected.getData(), responseActual.getData());

    }

    @Test(expected = DataNotFoundException.class)
    public void checkNationality() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3,"marwan","M",DOB,5000000,"81281626729","1","1",1);

        userServiceImpl.packetFunction(userDTOAct);
    }

    @Test(expected = DataNotFoundException.class)
    public void checkRegisteredNumber() throws ParseException, DataNotFoundException{
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3,"marwan","M",DOB,5000000,"+6281281626726","1","1",1);

        userServiceImpl.packetFunction(userDTOAct);

    }

    @Test(expected = DataNotFoundException.class)
    public void checkAge() throws ParseException, DataNotFoundException{
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3,"marwan","M",DOB,5000000,"+6281281626725","1","1",1);

        userServiceImpl.packetFunction(userDTOAct);

    }

    @Test(expected = DataNotFoundException.class)
    public void checkIncome()throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3,"marwan","M",DOB,5000000,"+6281281626724","1","1",1);

        userServiceImpl.packetFunction(userDTOAct);
    }

    @Test(expected = DataNotFoundException.class)
    public void checkSmokingStatus() throws ParseException, DataNotFoundException{
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3,"marwan","M",DOB,5000000,"+6281281626723","1","5",1);

        userServiceImpl.packetFunction(userDTOAct);
    }

    }
