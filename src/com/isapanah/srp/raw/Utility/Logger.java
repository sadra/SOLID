package com.isapanah.srp.raw.Utility;

public class Logger {

    public static void Error(String message, Exception exception)
    {
        System.out.println(message);
        exception.printStackTrace();
    }

}
