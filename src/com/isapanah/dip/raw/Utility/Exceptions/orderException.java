package com.isapanah.dip.raw.Utility.Exceptions;

import com.isapanah.dip.raw.Utility.Logger;

public class orderException extends Exception {
    public orderException(String message, Exception innerException)
    {
        super(message, innerException);
        Logger.error(message, innerException);
    }
}
