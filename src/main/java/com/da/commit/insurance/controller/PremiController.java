package com.da.commit.insurance.controller;

import com.da.commit.insurance.dto.PremiDTO;
import com.da.commit.insurance.exception.UserNotFoundException;
import com.da.commit.insurance.service.PremiService;
import com.da.commit.insurance.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping
public class PremiController {
    @Autowired
    PremiService premiService;

    /**
     * to get all premi data
     * @param premiDTO for save data to userdto
     * @return response that store data in the form of premi DTO
     * @throws UserNotFoundException when data is empty
     */
    @PostMapping(value = "/totalpremi", produces = "application/json")
    public Response<PremiDTO> premiPage (@RequestBody PremiDTO premiDTO) throws UserNotFoundException {
        return premiService.getPremi(premiDTO);
    }


}
