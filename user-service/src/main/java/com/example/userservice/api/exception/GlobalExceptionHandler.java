package com.example.userservice.api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userservice.constants.AppConstants;
import com.example.userservice.exception.DuplicateEmailException;
import com.example.userservice.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<Map<String, Object>> handleDuplicateEmail(DuplicateEmailException duplicateEmailException) {

		Map<String, Object> error = new HashMap<>();
		error.put(AppConstants.TIMESTAMP, LocalDateTime.now());
		error.put(AppConstants.STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
		error.put(AppConstants.ERROR, AppConstants.INTERNAL_SERVER_ERROR);
		error.put(AppConstants.MESSAGE, duplicateEmailException.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFoundException(
			UserNotFoundException userNotFoundException) {

		Map<String, Object> error = new HashMap<>();
		error.put(AppConstants.TIMESTAMP, LocalDateTime.now());
		error.put(AppConstants.STATUS, HttpStatus.NOT_FOUND);
		error.put(AppConstants.ERROR, "Not found");
		error.put(AppConstants.MESSAGE, userNotFoundException.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception exception) {
		Map<String, Object> error = new HashMap<>();
		error.put(AppConstants.TIMESTAMP, LocalDateTime.now());
		error.put(AppConstants.STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
		error.put(AppConstants.ERROR, AppConstants.INTERNAL_SERVER_ERROR);
		error.put(AppConstants.MESSAGE, exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
