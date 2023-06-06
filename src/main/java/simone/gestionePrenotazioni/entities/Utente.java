package simone.gestionePrenotazioni.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Utente {

	private long id;
	private String name;
	private String surname;

}