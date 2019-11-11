package com.metrica.formacion.apigruposmetrica.excepciones;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
public class CustomGlobalHandlerException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BuscarIdNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleNotFound(final BuscarIdNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ListarUsuariosNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleAllNotFound(final ListarUsuariosNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarFechaNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleFechaNotFound(final BuscarFechaNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarFechaAntesNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleFechaAntesNotFound(
			final BuscarFechaAntesNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarFechaEntreNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleFechaEntreNotFound(
			final BuscarFechaEntreNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarModificacionNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleModificacionNotFound(
			final BuscarModificacionNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarModificacionAntesNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleModificacionAntesNotFound(
			final BuscarModificacionAntesNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarModificacionEntreNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleModificacionEntreNotFound(
			final BuscarModificacionEntreNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(GrupoIdNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleGrupoSaveNotFound(final GrupoIdNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BorrarIdNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBorrarIdNotFound(final BorrarIdNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BorrarGrupoNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBorrarGrupoNotFound(final BorrarGrupoNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}
}
