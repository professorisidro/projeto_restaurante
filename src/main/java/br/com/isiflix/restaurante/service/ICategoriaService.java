package br.com.isiflix.restaurante.service;

import java.util.ArrayList;

import br.com.isiflix.restaurante.model.Categoria;

public interface ICategoriaService {
	public Categoria adicionarCategoria(Categoria c);
	public ArrayList<Categoria> recuperarTodas();
	public Categoria recuperarPeloCodigo(int codigo);
}
