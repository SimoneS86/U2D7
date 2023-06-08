package simone.gestionePrenotazioni.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import simone.gestionePrenotazioni.entities.Postazione;
import simone.gestionePrenotazioni.exceptions.NotFoundException;
import simone.gestionePrenotazioni.exceptions.RequestException;
import simone.gestionePrenotazioni.payload.PostazionePayload;
import simone.gestionePrenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {
	@Autowired
	private PostazioneRepository postazioneRepo;

	public Postazione create(PostazionePayload p) {
		postazioneRepo.findByDescrizione(p.getDescrizione()).ifPresent(Postazione -> {
			throw new RequestException("Postazione  già in presente!");
		});
		Postazione newPostazione = new Postazione(p.getDescrizione(), p.getTipo(), p.getOccupanti(), p.getEdificio());
		return postazioneRepo.save(newPostazione);
	}

	public Page<Postazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return postazioneRepo.findAll(pageable);
	}

	public Postazione findById(UUID id) throws NotFoundException {
		return postazioneRepo.findById(id).orElseThrow(() -> new NotFoundException("Postazione non trovato!"));
	}

	public Postazione findByIdAndUpdate(UUID id, PostazionePayload p) throws NotFoundException {
		Postazione found = this.findById(id);

		found.setId(id);
		found.setDescrizione(p.getDescrizione());
		found.setTipo(p.getTipo());
		found.setOccupanti(p.getOccupanti());

		return postazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Postazione found = this.findById(id);
		postazioneRepo.delete(found);
	}

}