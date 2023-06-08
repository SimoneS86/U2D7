package simone.gestionePrenotazioni.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import simone.gestionePrenotazioni.entities.Edificio;
import simone.gestionePrenotazioni.entities.Postazione.TipoPostazione;

@AllArgsConstructor
@Getter
public class PostazionePayload {
	@NotNull(message = "La descrizione è obbligatoria")
	@Size(min = 3, max = 30, message = "Descrizione min 3 caratteri, massimo 30")
	private String descrizione;
	@NotNull(message = "Il tipo è obbligatorio")
	private TipoPostazione tipo;
	@NotNull(message = "Il numero di occupanti è obbligatorio")
	private Integer occupanti;
	@NotNull(message = "L'edificio è obbligatorio")
	private Edificio edificio;

}