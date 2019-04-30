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
			return repository.save(obj);
		} else {
			obj.setEstoque(obj.getEstoque() + obj.getEstoque()); /* Atualizando o estoque */
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

	/* Buscar por Descricao */
	public List<Ferramenta> buscarPorDescricao(String descricao) {
		return repository.findByNome(descricao);
	}

	/* Delete */
	public void remove(Long id) {
		Ferramenta obj = new Ferramenta();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
