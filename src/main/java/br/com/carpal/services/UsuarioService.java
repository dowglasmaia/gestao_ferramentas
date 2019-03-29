package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Usuario;
import br.com.carpal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	/* Salvar ou Atualiza*/
	public Usuario salvar(Usuario obj) {
		//if (obj.getCodigo() == null) {
			return repository.save(obj);
		//} else {
		//	return repository.update(obj);
		//}
	}

	/* Listar Todos */
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Usuario buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* Buscar por nome */
	public List<Usuario> buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	/* Delete */
	public void remove(Long id) {
		Usuario obj = new Usuario();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
