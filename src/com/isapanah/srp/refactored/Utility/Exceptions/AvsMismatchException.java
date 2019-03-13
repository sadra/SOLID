package com.isapanah.srp.refactored.Utility.Exceptions;

public class AvsMismatchException extends Exception {
    public AvsMismatchException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
