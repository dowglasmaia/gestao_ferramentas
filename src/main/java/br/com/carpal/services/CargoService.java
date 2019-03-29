package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carpal.model.Cargo;
import br.com.carpal.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	/* Salvar */
	@Transactional(rollbackFor = {Exception.class})
	public Cargo salvar(Cargo obj) {
		if(obj.getId() == null){
			return repository.save(obj);
		}else {
			return repository.update(obj);
		}
		
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
	@Transactional(rollbackFor = {Exception.class})
	public Cargo update(Cargo obj) {
		Cargo newObj = buscarPorID(obj.getId());
		return repository.update(newObj);
	}

	/* Delete */
	@Transactional(rollbackFor = {Exception.class})
	public void remove(Long id) {
		Cargo obj = new Cargo();
		obj.setId(id);
		repository.delete(id);

	}

}
