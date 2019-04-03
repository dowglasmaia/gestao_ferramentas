package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Locacao;
import br.com.carpal.repository.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository repository;

	/* Salvar */
	public Locacao salvar(Locacao obj) {
		if (obj.getCodigo() == null) {
			return repository.save(obj);
		} else {
			return repository.update(obj);
		}
	}

	/* Listar Todos */
	public List<Locacao> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Locacao buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* Lista de Locações Por Usuario */
	public List<Locacao> findByUsuarios() {
		//impl  logica
		return null;
	}

	/* Delete */
	public void remove(Long id) {
		Locacao obj = new Locacao();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
