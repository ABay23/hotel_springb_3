package com.abay23.landonhotel.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResquestException extends RuntimeException{
    public BadResquestException() {
        super();
    }

    public BadResquestException(String message) {
        super(message);
    }

    public BadResquestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadResquestException(Throwable cause) {
        super(cause);
    }

}
