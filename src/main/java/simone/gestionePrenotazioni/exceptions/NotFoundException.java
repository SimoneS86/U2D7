package simone.gestionePrenotazioni.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}
}