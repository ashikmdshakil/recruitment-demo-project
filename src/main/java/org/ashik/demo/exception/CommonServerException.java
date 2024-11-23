package org.ashik.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CommonServerException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public CommonServerException(String message) {
        super(message);
    }

}
