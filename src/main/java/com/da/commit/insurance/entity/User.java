package com.da.commit.insurance.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
* UserRepository entity to store user related data from and into database
*/

@Data
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idUser;

    @Column
    private String name;

    @Column
    private String sex;

    @Column
    private Date birthDate;

    @Column
    private Integer income;

    @Column
    private String phoneNumber;

    @Column
    private String jobType;

    @Column
    private String smokingStatus;

    @Column
    private Integer plan;

}
