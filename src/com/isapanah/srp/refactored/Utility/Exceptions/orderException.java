package com.isapanah.srp.refactored.Utility.Exceptions;

public class orderException extends Exception {
    public orderException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
