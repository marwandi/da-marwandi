package com.da.commit.insurance.exception;

/**
 * exception to handle ...
 */

public class UserNotFoundException extends Exception{
    /**
     * Constructor with custom message
     * @param message for show error message
     */

    public UserNotFoundException(String message) {super(message);}
}
