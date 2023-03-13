package br.com.isiflix.restaurante.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.service.ICategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categorias")
	public ArrayList<Categoria> recuperarTodos(){
		return service.recuperarTodas();
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<?> adicionarNova(@RequestBody Categoria nova) {
		Categoria res = service.adicionarCategoria(nova);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.badRequest().build();
		//return ResponseEntity.status(201).body(res);
	}
	
	@GetMapping("/categorias/{codigo}")
	public ResponseEntity<Categoria> recuperarPeloCodigo(@PathVariable int codigo){
		Categoria res = service.recuperarPeloCodigo(codigo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
}
