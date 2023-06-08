package simone.gestionePrenotazioni.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simone.gestionePrenotazioni.entities.Prenotazione;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

}