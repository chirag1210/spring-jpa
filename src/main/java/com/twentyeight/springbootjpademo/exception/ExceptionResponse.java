package com.twentyeight.springbootjpademo.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date dateTimeStamp;
    private String message;
    private String details;

    public ExceptionResponse(Date dateTimeStamp, String message, String details) {
        this.dateTimeStamp = dateTimeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getDateTimeStamp() {
        return dateTimeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
