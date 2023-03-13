package br.com.isiflix.restaurante.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.model.Prato;
import br.com.isiflix.restaurante.service.IPratoService;

@RestController
public class PratoController {

	@Autowired
	private IPratoService service;
	
	@GetMapping("/pratos")
	public ArrayList<Prato> recuperarTodos(){
		return service.recuperarMenu();
	}
	
	@PostMapping("/pratos")
	public ResponseEntity<Prato> adicionarPrato(@RequestBody Prato prato){
		Prato res = service.adicionarPrato(prato);
		if (res != null) {
			
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/pratos/categoria/{codigo}")
	public ArrayList<Prato> recuperarPelaCategoria(@PathVariable int codigo){
		Categoria c = new Categoria();
		c.setCodigo(codigo);
		return service.recuperarPratosPorCategoria(c);
	}
	
	
}
