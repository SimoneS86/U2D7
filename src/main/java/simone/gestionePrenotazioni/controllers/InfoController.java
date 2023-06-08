package simone.gestionePrenotazioni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simone.gestionePrenotazioni.exceptions.RequestException;
import simone.gestionePrenotazioni.services.InfoPrenotazioniSrv;

@RestController
@RequestMapping("/infoprenotazioni")
public class InfoController {
	@Autowired
	InfoPrenotazioniSrv infoPrenotazioniSrv;

	@GetMapping("/{lang}")
	public String getMsg(@PathVariable String lang) {
		return infoPrenotazioniSrv.getInfoMSg(lang).orElseThrow(() -> new RequestException(lang));
	}
}
