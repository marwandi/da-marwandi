package com.da.commit.insurance.service;

import com.da.commit.insurance.dto.UserDTO;
import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.util.Response;

/**
* This class save method used in UserServiceImpl
*/

@FunctionalInterface
public interface UserService {

    /**
     * for method for  Userservice
     * @param userDTO for call userDTO
     * @return response
     * @throws DataNotFoundException for handling DataNotFoundException
     */

    Response<UserDTO> packetFunction (UserDTO userDTO) throws DataNotFoundException;

}
