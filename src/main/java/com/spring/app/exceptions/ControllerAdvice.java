package com.spring.app.exceptions;


import com.spring.app.dtos.response.DataResponseDTO;
import com.spring.app.exceptions.customsExceptions.BadRequestException;
import com.spring.app.exceptions.customsExceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> runtimeHandlerException(RuntimeException ex, HttpServletRequest request) {
        DataResponseDTO<?> error = DataResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .data(null)
                .responseCode(HttpStatus.BAD_REQUEST.value())
                .status("Error: Runtime")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestHandlerException(Exception ex, HttpServletRequest request) {

        DataResponseDTO<?> error = DataResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .data(null)
                .responseCode(HttpStatus.BAD_REQUEST.value())
                .status("Error: BadRequest")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNoValidHandlerException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        DataResponseDTO<?> error = DataResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .data(null)
                .responseCode(HttpStatus.BAD_REQUEST.value())
                .status("Error: Argument No Valid")
                .message(errors.toString())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class, IllegalArgumentException.class})
    public ResponseEntity<?> notFoundHandlerException(Exception ex, HttpServletRequest request) {

        DataResponseDTO<?> error = DataResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .data(null)
                .responseCode(HttpStatus.NOT_FOUND.value())
                .status("Error: NotFound")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            MethodArgumentTypeMismatchException.class,
            DataIntegrityViolationException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<?> invalidDataHandlerException(Exception ex, HttpServletRequest request) {

        DataResponseDTO<?> error = DataResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .data(null)
                .responseCode(HttpStatus.BAD_REQUEST.value())
                .status("Error: Invalid data entered")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
