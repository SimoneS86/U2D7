package simone.gestionePrenotazioni.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simone.gestionePrenotazioni.entities.Utente;

@Repository
public interface UsersRepository extends JpaRepository<Utente, UUID> {
	Optional<Utente> findByEmail(String email);
}