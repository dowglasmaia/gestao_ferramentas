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
		if(obj.getCodigo() == null){
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

	/* Buscar por nome */
	public List<Cargo> buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	/* Delete */	
	public void remove(Long id) {
		Cargo obj = new Cargo();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
