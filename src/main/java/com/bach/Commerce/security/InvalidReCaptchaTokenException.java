package com.bach.Commerce.security;

public class InvalidReCaptchaTokenException extends Exception {
    public InvalidReCaptchaTokenException(String message) {
        super(message);
    }
}
