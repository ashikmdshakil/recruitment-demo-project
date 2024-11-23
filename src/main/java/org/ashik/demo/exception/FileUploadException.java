package org.ashik.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class FileUploadException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public FileUploadException(String message) {
        super(message);
    }

}
