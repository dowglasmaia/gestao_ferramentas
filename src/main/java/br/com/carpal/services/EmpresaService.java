package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Empresa;
import br.com.carpal.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	/* Salvar */	
	public Empresa salvar(Empresa obj) {
		if (obj.getCodigo() == null) {
			return repository.save(obj);
		} else {
			return repository.update(obj);
		}
	}

	/* Listar Todos */
	public List<Empresa> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Empresa buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* Buscar por nome */
	public List<Empresa> buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	/* update */
	public Empresa update(Empresa obj) {
		Empresa newObj = buscarPorID(obj.getCodigo());
		return repository.update(newObj);
	}

	/* Delete */
	public void remove(Long id) {
		Empresa obj = new Empresa();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
