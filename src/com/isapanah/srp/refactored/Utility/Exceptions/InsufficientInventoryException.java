package com.isapanah.srp.refactored.Utility.Exceptions;

public class InsufficientInventoryException extends Exception {
    public InsufficientInventoryException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
