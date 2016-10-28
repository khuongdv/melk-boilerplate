package com.khuongdv.exception;

/**
 * Created by KhuongDV on 10/28/2016.
 */
public class MyException extends Exception {
    String message;
    String status;

    public MyException(String message, String status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
