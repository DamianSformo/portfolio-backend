package com.portfolio.portfolio.handler.exception;

public class UserUnauthorizedException extends RuntimeException{
    
    public UserUnauthorizedException(String message){
        super(message);
    }
}
