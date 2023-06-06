package simone.gestionePrenotazioni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simone.gestionePrenotazioni.exceptions.UnsupportedLanguageException;
import simone.gestionePrenotazioni.services.InfoPrenotazioniSrv;

@RestController
@RequestMapping("/infoprenotazioni")
public class InfoController {
	@Autowired
	InfoPrenotazioniSrv infoPrenotazioniSrv;

	@GetMapping("/{lang}")
	public String getMsg(@PathVariable String lang) {
		return infoPrenotazioniSrv.getInfoMSg(lang).orElseThrow(() -> new UnsupportedLanguageException(lang));
	}

//	@GetMapping("")
//	public String home(@RequestParam(defaultValue = "it") String lang) {
//		if (lang.equals("it")) {
//			return "Benvenuto, a seguire le regole per la prenotazione: ...";
//		} else if (lang.equals("en")) {
//			return "Welcome, here you are our reservation rules: ...";
//		} else {
//			throw new UnsupportedLanguageException(lang);
//		}
//	}
}