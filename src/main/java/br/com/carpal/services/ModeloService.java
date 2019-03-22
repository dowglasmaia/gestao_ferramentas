package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Modelo;
import br.com.carpal.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository repository;

	/* Salvar */
	public Modelo salvar(Modelo obj) {
		if(obj.getId() == null){
			return repository.save(obj);
		}else {
			return repository.update(obj);
		}
	}

	/* Listar Todos */
	public List<Modelo> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Modelo buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* update */
	public Modelo update(Modelo obj) {
		Modelo newObj = buscarPorID(obj.getId());
		return repository.update(newObj);
	}

	/* Delete */
	public void remove(Long id) {
		Modelo obj = new Modelo();
		obj.setId(id);
		repository.delete(id);

	}

}
