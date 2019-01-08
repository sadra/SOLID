package com.isapanah.srp.raw.Utility;

public class OrderException extends Exception {
    public OrderException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
