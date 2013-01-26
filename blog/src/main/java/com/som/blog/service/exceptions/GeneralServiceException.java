package com.som.blog.service.exceptions;

/**
 *
 * @author zhelezoglo
 */
public class GeneralServiceException extends RuntimeException{
    public GeneralServiceException(String message) {
        super(message);
    }
}
