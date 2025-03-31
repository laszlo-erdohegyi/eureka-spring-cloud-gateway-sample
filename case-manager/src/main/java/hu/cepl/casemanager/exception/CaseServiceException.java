package hu.cepl.casemanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CaseServiceException extends RuntimeException {

    private final HttpStatus httpStatus;

    public CaseServiceException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CaseServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CaseServiceException(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

}
