package com.polskowniaApp.utils.exception;

public class PasswordRequirementsNotMetException extends RuntimeException
{
    public PasswordRequirementsNotMetException(final String errorMessage)
    {
        super(errorMessage);
    }

}
