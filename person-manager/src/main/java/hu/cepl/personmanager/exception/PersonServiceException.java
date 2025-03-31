package hu.cepl.personmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PersonServiceException extends RuntimeException {

    private final HttpStatus httpStatus;

    public PersonServiceException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public PersonServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public PersonServiceException(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

}
