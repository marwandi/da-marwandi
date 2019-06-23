package com.da.commit.insurance.service.impl;

import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.entity.User;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.repository.UserRepository;
import com.da.commit.insurance.service.UserService;
import com.da.commit.insurance.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* This class is to process UserService related to request from UserController
*/


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    Response response = Response.builder().build();

    public Response<UserDTO> packetFunction(UserDTO userDTO) throws DataNotFoundException {
        checkNationality(userDTO);
        checkRegisteredNumber(userDTO);
        checkAge(userDTO);
        checkIncome(userDTO);
        checkSmokingStatus(userDTO);


        User user1 = new User();
        user1.setIdUser(userDTO.getIdUser());
        user1.setSex(userDTO.getSex());
        user1.setName(userDTO.getName());
        user1.setBirthDate(userDTO.getBirthDate());
        user1.setPhoneNumber(userDTO.getPhoneNumber());
        user1.setIncome(userDTO.getIncome());
        user1.setJobType(userDTO.getJobType());
        user1.setSmokingStatus(userDTO.getSmokingStatus());
        user1.setPlan(userDTO.getPlan());
        userRepository.save(user1);
        userDTO.setIdUser(user1.getIdUser());

        UserDTO userDto = new UserDTO(user1.getIdUser(), user1.getName(), user1.getSex(), user1.getBirthDate(), user1.getIncome(), user1.getPhoneNumber(), user1.getJobType(), user1.getSmokingStatus(), user1.getPlan());
        response.setResponseCode(HttpStatus.OK.toString());
        response.setResponseMessage("Success");
        response.setData(userDTO);

        return response;
    }

    /**
     * for validate nationality
     * @param userDTO for save data
     * @throws DataNotFoundException for handling DataNotFoundException
     */

    public void checkNationality (UserDTO userDTO) throws DataNotFoundException {
        if (("+62").equals(userDTO.getPhoneNumber().substring(0, 3))) {
            response.setResponseCode("0000");
            response.setResponseMessage("Indonesian Nationality can Register");
        }else{
            throw new DataNotFoundException("This Insurance only for Indonesian People");
        }
    }

    /**
     * for validate number register
     * @param userDTO for save data
     * @throws DataNotFoundException when data is empty
     */

    public void checkRegisteredNumber (UserDTO userDTO) throws DataNotFoundException {
        if (userRepository.findByPhoneNumber(userDTO.getPhoneNumber())== null) {
            response.setResponseCode("0000");
            response.setResponseMessage("Indonesian Nationality can Register");
        }else{
            throw new DataNotFoundException("Your Phone Number Already Registered");
        }
    }

    /**
     * for validate age of user
     * @param userDTO for save data
     * @throws DataNotFoundException when data is empty
     */

    public void checkAge (UserDTO userDTO) throws DataNotFoundException {
        Long date = new Date().getTime() - (userDTO.getBirthDate().getTime());
        Long age = date / 31536000000L;
        log.info(age.toString());
        if (age >= 17) {
            response.setResponseCode("0000");
            response.setResponseMessage("Your Age is Valid");
        }else{
            throw new DataNotFoundException("Your Age is Invalid / Not Enaugh");
        }
    }

    /**
     * for validate User Income
     * @param userDTO for save data
     * @throws DataNotFoundException when data is empty
     */

    public void checkIncome (UserDTO userDTO) throws DataNotFoundException {
        if (userDTO.getIncome()>= 5000000) {
            response.setResponseCode("0000");
            response.setResponseMessage("Your Income Is valid");
        }else{
            throw new DataNotFoundException("Your Income is Not Enough");
        }
    }

    /**
     * for validate smokingstatus
     * @param userDTO for save data
     * @throws DataNotFoundException when data is empty
     */

    public void checkSmokingStatus (UserDTO userDTO) throws DataNotFoundException {
        switch (userDTO.getSmokingStatus()) {
            case "0":
                response.setResponseMessage("Smoking");
                break;
                case"1":
                    response.setResponseMessage("No Smoking");
                    break;
                    default:
                throw new DataNotFoundException("Invalid Smoking Status");
        }
    }
}
