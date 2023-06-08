package simone.gestionePrenotazioni.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prenotazioni")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prenotazione {

	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	private Utente user;

	@ManyToOne
	@JsonIgnore
	private Postazione postazione;
	private LocalDate dataPrenotata;
	private LocalDate dataPrenotazione;

	public Prenotazione(Utente user, Postazione postazione, LocalDate dataPrenotata, LocalDate dataPrenotazione) {
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = dataPrenotazione;
	}

}