package hu.cepl.eventmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EventServiceException extends RuntimeException {

    private final HttpStatus httpStatus;

    public EventServiceException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public EventServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public EventServiceException(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

}
