package com.rating.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		Map map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("success", true);
		map.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity(map, HttpStatus.NOT_FOUND);
	}
}
