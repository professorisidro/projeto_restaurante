package br.com.isiflix.restaurante.service;

import java.util.ArrayList;

import br.com.isiflix.restaurante.model.Categoria;
import br.com.isiflix.restaurante.model.Prato;

public interface IPratoService {
	public Prato adicionarPrato(Prato p);
	public ArrayList<Prato> recuperarMenu();
	public Prato recuperarDetalheDoPrato(int codigo);
	public ArrayList<Prato> recuperarPratosPorCategoria(Categoria c);
}
