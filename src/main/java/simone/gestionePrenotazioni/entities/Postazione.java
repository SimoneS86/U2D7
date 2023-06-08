package simone.gestionePrenotazioni.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "postazioni")
public class Postazione {
	public enum TipoPostazione {
		PRIVATO, OPENSPACE, SALA_RIUNIONI;

	}

	@Id
	@GeneratedValue
	private UUID id;
	private String descrizione;
	private int occupanti;
	private TipoPostazione tipo;
	@ManyToOne
	private Edificio edificio;
	@ManyToOne
	@JsonIgnore
	private Utente user;

	public Postazione(UUID id, String descrizione, TipoPostazione tipo, int occupanti, Edificio edificio) {
		this.id = id;
		this.descrizione = descrizione;
		this.occupanti = occupanti;
		this.tipo = tipo;
		this.edificio = edificio;

	}

	public Postazione(String descrizione, TipoPostazione tipo, int occupanti, Edificio edificio) {
		this.descrizione = descrizione;
		this.occupanti = occupanti;
		this.tipo = tipo;
		this.edificio = edificio;

	}

	public Postazione(String descrizione, TipoPostazione tipo, int occupanti, Edificio edificio, Utente user) {
		this.descrizione = descrizione;
		this.occupanti = occupanti;
		this.tipo = tipo;
		this.edificio = edificio;
		this.user = user;
	}

}