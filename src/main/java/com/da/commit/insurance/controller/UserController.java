package com.da.commit.insurance.controller;

import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.service.UserService;
import com.da.commit.insurance.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* This class is used to receive user related requests
*/

@Slf4j
@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    /**
     * to get all user data
     * @param userDTO for save data to userdto
     * @return response that store data in the form of user DTO
     * @throws DataNotFoundException when data is empty
     */

    @PostMapping(value = "/register", produces = "application/json")
    public Response<UserDTO> policyNumber(@RequestBody UserDTO userDTO) throws DataNotFoundException {
        return userService.packetFunction(userDTO);
    }
}
