package com.felipedclc.workshopmongo.services.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipedclc.workshopmongo.resources.exception.StandardError;

@ControllerAdvice // CLASSE RESPONSAVEL POR TRATAR OS ERROS DAS REQUISIÇÕES
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // PADRAO DO SPRING
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
