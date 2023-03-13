package br.com.isiflix.restaurante.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.model.Prato;
import br.com.isiflix.restaurante.repo.PratoRepo;

@Component
public class PratoServiceImpl implements IPratoService{
	
	@Autowired
	private PratoRepo repo;

	@Override
	public Prato adicionarPrato(Prato p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public ArrayList<Prato> recuperarMenu() {
		// TODO Auto-generated method stub
		return (ArrayList<Prato>)repo.findAll();
	}

	@Override
	public Prato recuperarDetalheDoPrato(int codigo) {
		// TODO Auto-generated method stub
		return repo.findById(codigo).orElse(null);
	}

	@Override
	public ArrayList<Prato> recuperarPratosPorCategoria(Categoria c) {
		// TODO Auto-generated method stub
		return repo.findByCategoria(c);
	}

}
