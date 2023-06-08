package simone.gestionePrenotazioni.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import simone.gestionePrenotazioni.entities.Postazione;
import simone.gestionePrenotazioni.payload.PostazionePayload;
import simone.gestionePrenotazioni.services.PostazioneService;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
	@Autowired
	private PostazioneService postazioneService;

	@GetMapping("")
	public Page<Postazione> getPostazioni(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortedBy) {
		return postazioneService.find(page, size, sortedBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione savePostazione(@RequestBody @Validated PostazionePayload body) {
		return postazioneService.create(body);
	}

	@GetMapping("/{postazioneId}")
	public Postazione getPostazione(@PathVariable UUID postazioneId) throws Exception {
		return postazioneService.findById(postazioneId);
	}

	@PutMapping("/{postazioneId}")
	public Postazione updatePostazione(@PathVariable UUID postazioneId, @RequestBody @Validated PostazionePayload body)
			throws Exception {
		return postazioneService.findByIdAndUpdate(postazioneId, body);
	}

	@DeleteMapping("/{postazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePostazione(@PathVariable UUID postazioneId) {
		postazioneService.findByIdAndDelete(postazioneId);
	}

}