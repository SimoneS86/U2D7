package simone.gestionePrenotazioni;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import simone.gestionePrenotazioni.controllers.InfoController;

@WebMvcTest(InfoController.class)
public class InfoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomeEndpoint() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/info?lang=it")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content()
						.string("Benvenuto, a seguire le regole per la prenotazione: ..."));

		mockMvc.perform(MockMvcRequestBuilders.get("/info?lang=en")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Welcome, here you are our reservation rules: ..."));

		mockMvc.perform(MockMvcRequestBuilders.get("/info")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.content().string("Benvenuto, a seguire le regole per la prenotazione: ..."));
	}
}