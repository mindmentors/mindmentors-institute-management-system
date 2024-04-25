package com.mmc.app.platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class StaffDatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1746313772919956164L;

    public StaffDatabaseException(String message) {
        super(message);
    }

    public StaffDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

}