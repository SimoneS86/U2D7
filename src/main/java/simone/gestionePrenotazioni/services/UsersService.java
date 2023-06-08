package simone.gestionePrenotazioni.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import simone.gestionePrenotazioni.entities.Utente;
import simone.gestionePrenotazioni.exceptions.NotFoundException;
import simone.gestionePrenotazioni.exceptions.RequestException;
import simone.gestionePrenotazioni.payload.UserPayload;
import simone.gestionePrenotazioni.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;

	public Utente create(UserPayload u) {
		// TODO: check if email already exists
		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> {
			throw new RequestException("Email " + user.getEmail() + " already in use!");
		});
		Utente newUser = new Utente(u.getName(), u.getSurname(), u.getEmail());
		return usersRepo.save(newUser);
	}

	public Page<Utente> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return usersRepo.findAll(pageable);
	}

	public Utente findById(UUID id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));
	}

	public Utente findByIdAndUpdate(UUID id, UserPayload u) throws NotFoundException {
		Utente found = this.findById(id);

		found.setId(id);
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());

		return usersRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Utente found = this.findById(id);
		usersRepo.delete(found);
	}

}