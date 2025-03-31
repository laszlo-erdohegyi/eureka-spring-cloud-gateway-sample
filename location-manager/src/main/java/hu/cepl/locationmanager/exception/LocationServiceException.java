package hu.cepl.locationmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LocationServiceException extends RuntimeException {

    private final HttpStatus httpStatus;

    public LocationServiceException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public LocationServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public LocationServiceException(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

}
