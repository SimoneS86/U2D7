package simone.gestionePrenotazioni.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RequestException.class)
	public ResponseEntity<ErrorsPayload> handleUnsupportedLanguage(RequestException e) {
		ErrorsPayload payload = new ErrorsPayload("Unsupported language: " + e.getLanguage(), new Date(), 400);
		return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorsPayload> handleGenericErrors(Exception e) {
		System.out.println(e);
		ErrorsPayload payload = new ErrorsPayload("GENERIC SERVER ERROR! WE GONNA FIX IT ASAP!", new Date(), 500);
		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}