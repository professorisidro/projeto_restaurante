package br.com.isiflix.restaurante.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.repo.CategoriaRepo;

@Component
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private CategoriaRepo repo;

	@Override
	public Categoria adicionarCategoria(Categoria c) {
		// TODO Auto-generated method stub
		System.out.println(c);
		if (c.getDescricao() == null || c.getDescricao().length() == 0)
			return null;
		return repo.save(c);
	}

	@Override
	public ArrayList<Categoria> recuperarTodas() {
		// TODO Auto-generated method stub
		return (ArrayList<Categoria>)repo.findAll();
	}

	@Override
	public Categoria recuperarPeloCodigo(int codigo) {
		// TODO Auto-generated method stub
		return repo.findById(codigo).orElse(null);
	}

}
