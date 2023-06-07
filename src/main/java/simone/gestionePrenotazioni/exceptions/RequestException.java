package simone.gestionePrenotazioni.exceptions;

import lombok.Getter;

@Getter
public class RequestException extends RuntimeException {

	private final String language;

	public RequestException(String language) {
		super("Unsupported language: " + language);
		this.language = language;
	}
}