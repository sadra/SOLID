package com.isapanah.dip.refactored.Utility.Exceptions;

import com.isapanah.dip.refactored.Utility.Logger;

public class orderException extends Exception {
    public orderException(String message, Exception innerException)
    {
        super(message, innerException);
    }
}
