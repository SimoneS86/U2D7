package simone.gestionePrenotazioni.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import simone.gestionePrenotazioni.entities.Edificio;
import simone.gestionePrenotazioni.services.EdificioService;

@RestController
@RequestMapping("/edifici")
public class EdificioController {
	@Autowired
	private EdificioService edificioService;

	@GetMapping("")
	public Page<Edificio> getEdificio(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortedBy) {
		return edificioService.find(page, size, sortedBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Edificio saveEdificio(@RequestBody Edificio body) {
		return edificioService.create(body);
	}

	@GetMapping("/{edificioId}")
	public Edificio getEdificio(@PathVariable UUID edificioId) throws Exception {
		return edificioService.findById(edificioId);
	}

	@DeleteMapping("/{edificioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEdificio(@PathVariable UUID edificioId) {
		edificioService.findByIdAndDelete(edificioId);
	}

}