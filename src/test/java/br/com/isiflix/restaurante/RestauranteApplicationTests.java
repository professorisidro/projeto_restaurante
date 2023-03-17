package br.com.isiflix.restaurante;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.service.ICategoriaService;

@SpringBootTest
@ActiveProfiles("test")
class RestauranteApplicationTests {

	
	@Autowired
	private ICategoriaService service;
	

	
	@Test
	public void deveriaCadastrarUmaCategoria() {		
		Categoria c = new Categoria();
		c.setDescricao("Entradas");
		Categoria res = service.adicionarCategoria(c);
		assertTrue(res != null && res.getCodigo() > 0);
	}
	
	@Test
	public void naoPodeCadastrarCategoria() {
		Categoria c = new Categoria();
		Categoria res = service.adicionarCategoria(c);
		assertTrue(res == null);
	}
	
}
