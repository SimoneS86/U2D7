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

import simone.gestionePrenotazioni.entities.Utente;
import simone.gestionePrenotazioni.payload.UserPayload;
import simone.gestionePrenotazioni.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	@GetMapping("")
	public Page<Utente> getUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return usersService.find(page, size, sortBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody @Validated UserPayload body) {
		return usersService.create(body);
	}

	@GetMapping("/{userId}")
	public Utente getUser(@PathVariable UUID userId) throws Exception {
		return usersService.findById(userId);
	}

	@PutMapping("/{userId}")
	public Utente updateUser(@PathVariable UUID userId, @RequestBody @Validated UserPayload body) throws Exception {
		return usersService.findByIdAndUpdate(userId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID userId) {
		usersService.findByIdAndDelete(userId);
	}

}