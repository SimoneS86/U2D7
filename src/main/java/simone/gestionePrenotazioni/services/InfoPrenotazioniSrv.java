package simone.gestionePrenotazioni.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class InfoPrenotazioniSrv {
	private Map<String, String> infoPrenotazioniMsg = Map.of("it", "Regole per la prenotazione:....", "en",
			"Booking rules:.....");

	public Optional<String> getInfoMSg(String lang) {
		return Optional.ofNullable(infoPrenotazioniMsg.get(lang));
	}

}