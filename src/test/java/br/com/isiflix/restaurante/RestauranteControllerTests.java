package br.com.isiflix.restaurante;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/* Testes de Integração o "buraco é mais embaixo"
 * porque agora queremos ver se o nosso controller consegue fazer a chamada correta para o serviço
 * e retornar corretamente os status HTTP (e seus respectivos conteúdos) para quem os chamou
 * 
 * para isso vamos usar o objeto MockMvc (ele vai simular o Postman pra nós - tudo em código)
 * 
 * 
 * 	Método que vamos usar:
 * 		perform (que vai fazer uma requisição HTTP). Este componente tem os métodos
 * 			get()
 * 			post() 
 * 
 * 
 * 	independente deles, ambos são membros de um cara que realiza requisições:
 * 	O MockMvcRequestBuilders (ou seja, o objeto criador de requisições HTTP do Mock)
 *  
 *  Em seguida ao PERFORM, temos o 
 *  	.andExpect() - que é justamente o que a gente precisa esperar do retorno da requisição
 *  
 *  aqui podemos testar várias coisas: desde o status do retorno até o conteúdo da mensagem vinda
 *     - como testar o status? Através do objeto MockMvcResultMatchers 
 *     	(o objeto que é responsável pelo "match" entre o que se espera de resposta e a resposta
 *     	 efetiva) 
 * 		.status()  --> pra nós o Status é o mais importante agora
 * 		.content()
 * 		.header()
 * 
 * 
 *  Um adendo ao método POST do MockMvcRequestBuilder
 *  
 *  	- preciso ter a STRING do meu objeto JSON pronta (isso é chato de montar)
 *  	- preciso logo após o POST, combinar 2 coisas
 *  			- o cabeçalho que indica que é uma string json: contentType("application/json")
 *  			- o conteúdo: content(categJson)
 *  
 *  então como ficaria?
 *  
 *  mockMvc.perform(MockMvcRequestBuilders.post(**URL***)
 *                                        .contentType(**falo que é json**)
 *                                        .content(** o Json do objeto **))
 *                                        
 *                                        
 */


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
	
	@Test
	public void recuperarCategoriaQueExiste() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/categorias/20"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void recuperarCategoriaQueNaoExiste() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/categorias/50"))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
