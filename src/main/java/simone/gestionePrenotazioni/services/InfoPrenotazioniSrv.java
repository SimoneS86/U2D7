package simone.gestionePrenotazioni.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class InfoPrenotazioniSrv {
	private Map<String, String> infoPrenotazioniMsg = Map.of("it", "Queste sono le regole per la prenotazione:....",
			"en", "This is the booking rules:.....");

	public Optional<String> getInfoMSg(String lang) {
		return Optional.ofNullable(infoPrenotazioniMsg.get(lang));
	}

}