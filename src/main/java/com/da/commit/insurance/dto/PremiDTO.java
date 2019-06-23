package com.da.commit.insurance.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * DTO for storing Premi related request to be parsed into Response
 */

@Data
public class PremiDTO {

    @NotNull
    private Integer idUser;

    @NotNull
    private Integer idPlan;

    @NotNull
    private BigDecimal totalPremi;
}
