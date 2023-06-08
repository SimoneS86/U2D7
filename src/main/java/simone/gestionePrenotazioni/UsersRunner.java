package simone.gestionePrenotazioni;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import simone.gestionePrenotazioni.payload.UserPayload;
import simone.gestionePrenotazioni.services.UsersService;

@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 500; i++) {
			try {

				String name = faker.name().firstName();
				String surname = faker.name().lastName();
				String email = faker.internet().emailAddress();
				UserPayload user = new UserPayload(name, surname, email);
//				usersService.create(user);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}