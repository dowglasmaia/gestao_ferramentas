package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Fabricante;
import br.com.carpal.model.Fabricante;
import br.com.carpal.repository.FabricanteRepository;
import br.com.carpal.repository.FabricanteRepository;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository repository;

	/* Salvar */
	public Fabricante salvar(Fabricante obj) {
		return repository.save(obj);
	}

	/* Listar Todos */
	public List<Fabricante> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Fabricante buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* update */
	public Fabricante update(Fabricante obj) {
		Fabricante newObj = buscarPorID(obj.getId());
		return repository.update(newObj);
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Fabricante obj = new Fabricante();
		obj.setId(id);
		repository.delete(id);

	}

}
