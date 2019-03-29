package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Ferramenta;
import br.com.carpal.repository.FerramentaRepository;

@Service
public class FerramentaService {

	@Autowired
	private FerramentaRepository repository;

	/* Salvar */
	public Ferramenta salvar(Ferramenta obj) {
		if (obj.getCodigo() == null) {
			obj.setEstoque(obj.getQuantidade()); /*Atualizando o estoque*/
			return repository.save(obj);
		} else {
			obj.setEstoque(obj.getEstoque() + obj.getQuantidade()); /*Atualizando o estoque*/
			return repository.update(obj);
		}

	}

	/* Listar Todos */
	public List<Ferramenta> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Ferramenta buscarPorID(Long id) {
		return repository.findById(id);
	}


	/* Delete */
	public void remove(Long id) {
		Ferramenta obj = new Ferramenta();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
