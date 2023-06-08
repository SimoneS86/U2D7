package simone.gestionePrenotazioni.entities;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "edifici")
public class Edificio {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String indirizzo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Citta citta;

	public Edificio(String name, String indirizzo, Citta citta) {
		this.name = name;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
}