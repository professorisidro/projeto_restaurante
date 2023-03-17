package br.com.isiflix.restaurante;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class RestauranteControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testeEndpointAdicionarCategoria() throws Exception{
		String categJson = "{ \"descricao\":\"Teste\"} ";
		mvc.perform(MockMvcRequestBuilders.post("/categorias")
				                          .contentType("application/json")
				                          .content(categJson))			
			.andExpect(MockMvcResultMatchers.status().is(201));		
	}
	@Test
	public void testeEndpointAdicionarCategoriaComErro() throws Exception{
		String categJson = "{ \"descricao\":\"\"} ";
		mvc.perform(MockMvcRequestBuilders.post("/categorias")
				                          .contentType("application/json")
				                          .content(categJson))			
			.andExpect(MockMvcResultMatchers.status().is(400));		
	}
}
