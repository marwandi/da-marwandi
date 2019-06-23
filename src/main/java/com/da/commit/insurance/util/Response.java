package com.da.commit.insurance.util;


import lombok.Builder;
import lombok.Data;

/**
 * This class is stored response data
 * @param <T> response data
 */

@Data
@Builder
public class Response <T>{

    private String responseCode;
    private String responseMessage;
    private T data;
}
