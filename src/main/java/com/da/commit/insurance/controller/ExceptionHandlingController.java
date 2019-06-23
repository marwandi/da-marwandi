package com.da.commit.insurance.controller;

import com.da.commit.insurance.exception.DataNotFoundException;
import com.da.commit.insurance.exception.UserNotFoundException;
import com.da.commit.insurance.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This class is used for custom error message
 */

@ControllerAdvice
public class ExceptionHandlingController {
    /**
     * ExcpetionHandlingController for UserNotFoundException
     * @param exception for UserNotFoundException
     * @return error
     */

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    Response handleUserNotFound(final UserNotFoundException exception) {

        Response error = Response.builder().build();
        error.setResponseCode(HttpStatus.NOT_FOUND.toString());
        error.setResponseMessage(exception.getMessage());

        return error;
    }

    /**
     * ExcpetionHandlingController for DataNotFoundException
     * @param exception for DataNotFoundException
     * @return error
     */

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    Response handleDataNotFound(final DataNotFoundException exception) {

        Response error = Response.builder().build();
        error.setResponseCode(HttpStatus.NOT_FOUND.toString());
        error.setResponseMessage(exception.getMessage());

        return error;
    }



}
