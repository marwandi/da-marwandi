package com.da.commit.insurance.service;

import com.da.commit.insurance.dto.PremiDTO;
import com.da.commit.insurance.exception.UserNotFoundException;
import com.da.commit.insurance.util.Response;

/**
 * This class save method used in PremiServiceImpl
 */
@FunctionalInterface
public interface PremiService {
    /**
     * for logic of premi
     * @param premiDTO for save data to premidto
     * @return response that store data in the form of premi DTO
     * @throws UserNotFoundException when data is empty
     */
    Response<PremiDTO> getPremi (PremiDTO premiDTO) throws UserNotFoundException;
}
