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
		if(obj.getCodigo() == null){
			return repository.save(obj);
		}else {
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

	/* update */
	public Ferramenta update(Ferramenta obj) {
		Ferramenta newObj = buscarPorID(obj.getCodigo());
		return repository.update(newObj);
	}

	/* Delete */
	public void remove(Long id) {
		Ferramenta obj = new Ferramenta();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
