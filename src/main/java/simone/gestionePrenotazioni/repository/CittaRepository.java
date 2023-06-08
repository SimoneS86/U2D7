package simone.gestionePrenotazioni.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simone.gestionePrenotazioni.entities.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, UUID> {
	Optional<Citta> findByNameIgnoreCase(String nome);

}