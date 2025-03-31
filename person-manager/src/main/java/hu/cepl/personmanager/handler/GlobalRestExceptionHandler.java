package hu.cepl.personmanager.handler;

import hu.cepl.personmanager.exception.PersonServiceException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonServiceException.class)
    public ResponseEntity<ErrorResponse> handleCaseServiceException(PersonServiceException ex) {
        ErrorResponse resp = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(ex.getHttpStatus().value())
                .error(ex.getHttpStatus().getReasonPhrase())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(resp.getStatus()));
    }

}
