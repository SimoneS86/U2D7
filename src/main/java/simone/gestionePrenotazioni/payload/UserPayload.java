package simone.gestionePrenotazioni.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPayload {
	@NotNull(message = "Il nome è obbligatorio")
	@Size(min = 3, max = 30)
	String name;
	@NotNull(message = "Il cognome è obbligatorio")
	String surname;
	@Email(message = "Non hai inserito un indirizzo email valido")
	String email;
}