package dev.sidebit.planeja.infra.handlers;

import dev.sidebit.planeja.common.exceptions.RegisterNotFindException;
import dev.sidebit.planeja.common.exceptions.ValidationException;
import dev.sidebit.planeja.common.validation.FieldInvalid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e){
        var status = HttpStatus.UNPROCESSABLE_CONTENT;
        var body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", e.getMessage(),
                "fieldsInvalids", e.getFieldsInvalids()
        );

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var fieldsInvalids = e.getFieldErrors()
                .stream()
                .map(fieldError -> new FieldInvalid(fieldError.getField(),fieldError.getDefaultMessage()))
                .toList();
        var status = HttpStatus.UNPROCESSABLE_CONTENT;
        var body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", e.getMessage(),
                "fieldsInvalids", fieldsInvalids
        );

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(RegisterNotFindException.class)
    public ResponseEntity<?> handleRegisterNotFindException(RegisterNotFindException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                    "timestamp", LocalDateTime.now(),
                    "status", HttpStatus.NOT_FOUND.value(),
                    "error", e.getMessage(),
                    "message", e.getMessage()
                ));
    }
}
