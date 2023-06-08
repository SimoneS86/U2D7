package simone.gestionePrenotazioni.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import simone.gestionePrenotazioni.entities.Edificio;
import simone.gestionePrenotazioni.exceptions.NotFoundException;
import simone.gestionePrenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepo;

	public Edificio create(Edificio e) {
		return edificioRepo.save(e);
	}

//	public void createFromList(List<Edificio> e) {
//		edificioRepo.saveAll(e);
//	}

	public Edificio findById(UUID id) {
		return edificioRepo.findById(id).orElseThrow(() -> new NotFoundException("Edificio non trovato!"));
	}

	public Page<Edificio> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return edificioRepo.findAll(pageable);
	}

	public void findByIdAndDelete(UUID id) {
		Edificio found = this.findById(id);
		edificioRepo.delete(found);
	}
}