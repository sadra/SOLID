package com.isapanah.srp.refactored.Utility.Exceptions;

public class OrderException extends Exception {
    public OrderException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
