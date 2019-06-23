package com.da.commit.insurance.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Premi entity to store premi related data from and into database
 */
@Data
@Entity
public class Premi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "idPlan")
    private Integer idPlan;

    @Column(name = "totalPremi")
    private BigDecimal totalPremi;

}
