package simone.gestionePrenotazioni.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simone.gestionePrenotazioni.entities.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
//	List<Postazione> findByTipoAndEdificio_Citta_NameIgnoreCase(TipoPostazione tipo, String name);
//
//	List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, Citta citta);
	Optional<Postazione> findByDescrizione(String descrizione);

}