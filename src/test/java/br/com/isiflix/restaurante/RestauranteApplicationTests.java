package br.com.isiflix.restaurante;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
		System.out.println("--- cadastrando categoria");
		Categoria c = new Categoria();
		c.setCodigo(1);
		c.setDescricao("Entradas");
		Categoria res = service.adicionarCategoria(c);
		assertTrue(res != null && res.getCodigo() > 0); // quero conferir se as 2 condições são verdadeiras
	}
	
	@Test
	public void naoPodeCadastrarCategoria() {
		System.out.println("--- cadastrando categoria invalida");
		Categoria c = new Categoria();
		c.setCodigo(12);
		Categoria res = service.adicionarCategoria(c);
		assertNull(res);  // quero efetivamente conferir se o resultado é NULL
	}
	
	@Test
	public void recuperarCategoriaExistente() {		
		System.out.println("--- recuperando todas as categorias");
		List<Categoria> lista = service.recuperarTodas();
		System.out.println("LISTA = "+lista);
		assertNotNull(lista); // quero conferir se a minha lista não é NULL
	}	
}