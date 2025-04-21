package workspace_management.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import workspace_management.exception.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({WrongCustomerException.class})
    public ResponseEntity<String> handleExceptionWith403Code(WrongCustomerException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ReservationNotFoundException.class, WorkspaceNotFoundException.class})
    public ResponseEntity<String> handleExceptionWith404Code(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WorkspaceNotAvailableException.class, CustomerNotFoundException.class})
    public ResponseEntity<String> handleExceptionWith409Code(WorkspaceNotAvailableException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
