package com.da.commit.insurance.dto;

import com.da.commit.insurance.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* DTO for storing User related request to be parsed into Response
*/

@Data
@AllArgsConstructor
public class UserDTO {
    @NotNull
    private Integer idUser;

    @NotNull
    private String name;

    @NotNull
    private String sex;

    @NotNull
    private Date birthDate;

    @NotNull
    private Integer income;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String jobType;

    @NotNull
    private String smokingStatus;

    @NotNull
    private Integer plan;

}
