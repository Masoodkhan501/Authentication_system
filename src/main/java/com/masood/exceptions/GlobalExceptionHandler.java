package com.masood.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.masood.dtos.ExceptionResDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ExceptionResDTO> handleResourceNotFoundException(ResourceNotFound re,
			HttpServletRequest req) {

		ExceptionResDTO exceptionResponse = new ExceptionResDTO(Instant.now(), HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), re.getMessage(), req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResDTO> handleRuntimeException(RuntimeException re, HttpServletRequest req) {

		ExceptionResDTO exceptionResponse = new ExceptionResDTO(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), re.getMessage(), req.getRequestURI());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResDTO> handleException(Exception e, HttpServletRequest req){
		
		ExceptionResDTO exceptionResponse = new ExceptionResDTO(
				Instant.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				e.getMessage(),
				req.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
				
	}

}