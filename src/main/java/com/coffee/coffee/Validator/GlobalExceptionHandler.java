package com.coffee.coffee.Validator;

import com.coffee.coffee.Models.ResponseObject;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        List<String> body = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(404, "failed validator", body));
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ErrorDetaill> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
//        List<String> errors = new ArrayList<>();
//
//        ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));
//
//        Map<String, List<String>> result = new HashMap<>();
//        result.put("errors", errors);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDetaill("200", "Failed validator", result));
//    }
}
