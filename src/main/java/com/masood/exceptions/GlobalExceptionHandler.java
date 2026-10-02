package com.masood.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.masood.dtos.ExceptionResDTO;
import com.masood.dtos.multiFieldValidationExceptionResDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ExceptionResDTO> handleResourceNotFoundException(ResourceNotFound re,
			HttpServletRequest req) {

		ExceptionResDTO exceptionResponse = new ExceptionResDTO(
				Instant.now(), 
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), 
				re.getMessage(), 
				req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResDTO> handleRuntimeException(RuntimeException re, 
			HttpServletRequest req) {

		ExceptionResDTO exceptionResponse = new ExceptionResDTO(
				Instant.now(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				re.getMessage(), 
				req.getRequestURI());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResDTO> handleException(Exception ex, 
			HttpServletRequest req){
		
		ExceptionResDTO exceptionResponse = new ExceptionResDTO(
				Instant.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				ex.getMessage(),
				req.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
				
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<multiFieldValidationExceptionResDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException me,
			HttpServletRequest req){
		
		Map<String, String> fieldErrors = new HashMap<>();
		
		me.getBindingResult().getFieldErrors()
		.forEach(error -> fieldErrors.put(error.getField(),error.getDefaultMessage()));
		
		multiFieldValidationExceptionResDTO exceptionResponse = new multiFieldValidationExceptionResDTO(
				Instant.now(),
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(),
				"Fields are invalid.",
				req.getRequestURI(),
				fieldErrors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<ExceptionResDTO> handleDuplicateRecordException(DuplicateRecordException de,HttpServletRequest req){
		
		ExceptionResDTO exceptionResponse = new ExceptionResDTO(
				Instant.now(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(),
				de.getMessage(),
				req.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
		
	}
	

}