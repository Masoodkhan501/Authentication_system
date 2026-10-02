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

		ExceptionResDTO exceptionResponse = new ExceptionResDTO(
				Instant.now(), 
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), 
				re.getMessage(), 
				req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

}