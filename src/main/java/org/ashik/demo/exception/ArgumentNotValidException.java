package org.ashik.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ArgumentNotValidException(String message) {
        super(message);
    }
}
