package com.da.commit.insurance.controller;


import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.service.UserService;
import com.da.commit.insurance.service.impl.UserServiceImpl;
import com.da.commit.insurance.util.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    public void policyNumber() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);

        UserDTO userDTOAct = new UserDTO(3, "marwan", "M",DOB, 5000000, "+62821321321", "1", "1", 1);

        Response responseExpected = Response.builder()
                .data(userDTOAct)
                .build();

        UserDTO userDTOExp = new UserDTO(3, "marwan", "M",DOB, 5000000, "+62821321321", "1", "1", 1);


        UserDTO userDTO = new UserDTO(3, "marwan", "M",DOB, 5000000, "+62821321321", "1", "1", 1);
        Response responseActual = userController.policyNumber(userDTO);

        assertEquals(responseExpected.getData(), responseActual.getData());

    }

    @Test(expected = DataNotFoundException.class)
    public void checkNationality() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3, "marwan", "M",DOB, 5000000, "123123212", "1", "1", 1);

        userServiceImpl.packetFunction(userDTOAct);

    }

    @Test(expected = DataNotFoundException.class)
    public void checkRegisteredNumber() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3, "marwan", "M",DOB, 5000000, "+6283456456", "1", "1", 1);

        userServiceImpl.packetFunction(userDTOAct);

    }

    @Test(expected = DataNotFoundException.class)
    public void checkAge() throws ParseException, DataNotFoundException {
        String date = "2017-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3, "marwan", "M",DOB, 5000000, "+62813234332", "1", "1", 1);

        userServiceImpl.packetFunction(userDTOAct);

    }

    @Test(expected = DataNotFoundException.class)
    public void checkIncome() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3, "marwan", "M",DOB, 5000000, "+62821321321", "1", "1", 1);

        userServiceImpl.packetFunction(userDTOAct);

    }

    @Test(expected = DataNotFoundException.class)
    public void checkSmokingStatus() throws ParseException, DataNotFoundException {
        String date = "1982-02-02";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date DOB = format.parse(date);
        UserDTO userDTOAct = new UserDTO(3, "marwan", "M",DOB, 5000000, "+62821321321", "1", "1", 1);

        userServiceImpl.packetFunction(userDTOAct);

    }
}
