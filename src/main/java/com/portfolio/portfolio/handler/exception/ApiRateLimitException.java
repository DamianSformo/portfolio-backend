package com.portfolio.portfolio.handler.exception;

public class ApiRateLimitException extends RuntimeException{
    
    public ApiRateLimitException(String message){
        super(message);
    }
}
