package com.da.commit.insurance.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Paket entity to store paket related data from and into database
 */
@Data
@Entity
public class Plan {
    @Id
    @Column
    private Integer idPlan;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private String description;

    @Column
    private Integer minAge;

    @Column
    private Integer minIncome;


}
