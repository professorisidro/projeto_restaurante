package br.com.isiflix.restaurante.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.isiflix.restaurante.model.Categoria;

public interface CategoriaRepo extends CrudRepository<Categoria, Integer>{

}
