package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Empresa;
import br.com.carpal.model.Usuario;
import br.com.carpal.model.dto.UsuarioNewDTO;
import br.com.carpal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository repository;

	/* Salvar */
	public Usuario salvar(Usuario obj) {
		return repository.save(obj);

	}

	/* Salvando o Funcionario e Suas Referencias */
	public Usuario fromDTO(UsuarioNewDTO objDTO) {

		Cargo cargo = objDTO.getCargo();
		Empresa empresa = objDTO.getEmpresa();

		Usuario usuario = new Usuario(null, objDTO.getMatricula(), objDTO.getNome(), objDTO.getCpf(),
				objDTO.getContato(), cargo, empresa, pe.encode(objDTO.getSenha()));

		return usuario;

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
