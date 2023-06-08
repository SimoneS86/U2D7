package simone.gestionePrenotazioni.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Utente {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String surname;
	private String email;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Prenotazione> prenotazioni;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Postazione> postazioni;

	public Utente(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

}