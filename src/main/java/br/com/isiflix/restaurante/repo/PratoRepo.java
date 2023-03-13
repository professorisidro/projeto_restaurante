package br.com.isiflix.restaurante.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.model.Prato;

public interface PratoRepo extends CrudRepository<Prato, Integer>{
	public ArrayList<Prato> findByCategoria(Categoria c);
}
