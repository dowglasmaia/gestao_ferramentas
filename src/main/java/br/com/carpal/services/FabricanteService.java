package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carpal.model.Fabricante;
import br.com.carpal.repository.FabricanteRepository;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository repository;

	/* Salvar */
	@Transactional(rollbackFor = {Exception.class})
	public Fabricante salvar(Fabricante obj) {
		if (obj.getId() == null) {
			return repository.save(obj);
		} else {
			return repository.update(obj);
		}
	}

	/* Listar Todos */
	public List<Fabricante> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Fabricante buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* Buscar por nome */
	public List<Fabricante> buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	/* update */
	@Transactional(rollbackFor = {Exception.class})
	public Fabricante update(Fabricante obj) {
		Fabricante newObj = buscarPorID(obj.getId());
		return repository.update(newObj);
	}

	/* Delete */
	@Transactional(rollbackFor = {Exception.class})
	public void remove(Long id) {
		Fabricante obj = new Fabricante();
		obj.setId(id);
		repository.delete(id);

	}

}
