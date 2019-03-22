package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Cargo;
import br.com.carpal.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	/* Salvar */
	public Cargo salvar(Cargo obj) {
		return repository.save(obj);
	}

	/* Listar Todos */
	public List<Cargo> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Cargo buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* update */
	public Cargo update(Cargo obj) {
		Cargo cargo = buscarPorID(obj.getId());
		return repository.update(cargo);
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Cargo obj = new Cargo();
		obj.setId(id);
		repository.delete(id);

	}

}
