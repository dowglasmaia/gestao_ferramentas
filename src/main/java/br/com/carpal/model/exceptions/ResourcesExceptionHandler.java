package br.com.carpal.model.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.carpal.services.exceptions.AuthorizationException;
import br.com.carpal.services.exceptions.DataIntegrityException;
import br.com.carpal.services.exceptions.FileException;
import br.com.carpal.services.exceptions.ObjectNotFoundException;

/*Class de Recursos de Erro Pensonalizado*/

@ControllerAdvice
public class ResourcesExceptionHandler {
	
	// Exceção para Objetos Não Encontrados
		@ExceptionHandler(ObjectNotFoundException.class)
		public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request) {
			
			StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
					"Não encontrado", e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}

		// Exceção para Dados Não Encontrados
		@ExceptionHandler(DataIntegrityException.class)
		public ResponseEntity<StandardError> dataIntegreity(DataIntegrityException e, HttpServletRequest request) {
			
			StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
					"Integridade de Dados", e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		}

		// Exceção Personaliza para Validação de Dados(Formularios) - com o error 422 
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

			ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
					"Erro de Validação", e.getMessage(), request.getRequestURI());
			for (FieldError x : e.getBindingResult().getFieldErrors()) {
				err.addError(x.getField(), x.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
		}

		// Exceção para Objetos Não Autorizados!!!
		@ExceptionHandler(AuthorizationException.class)
		public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
			
			StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso Negado",
					e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
		}

		// Exceção para FileException!!!
	@ExceptionHandler(FileException.class)
		public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {
			
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
					"Erro de Aquivo", e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		}

}
