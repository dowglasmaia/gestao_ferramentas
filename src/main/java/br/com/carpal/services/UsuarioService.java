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
import br.com.carpal.repository.datajpa.UsuarioRepoJPA;
import br.com.carpal.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioRepoJPA repoJPA;

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

	/* Buscar por CPF */
	public List<Usuario> buscarPorCpf(String cpf) {
		List<Usuario> user = repository.findByCpf(cpf);
		try {
			if (user != null) {
				return user;
			}
		} catch (RuntimeException e) {
			throw new ObjectNotFoundException("Usuario Não Encontrado", e);
		}
		return null;
	}

	/* Find By Cpf */
	public Usuario findByCpf(String cpf) {
		return repoJPA.findByCpf(cpf);
	}

	/* Delete */
	public void remove(Long id) {
		Usuario obj = new Usuario();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
