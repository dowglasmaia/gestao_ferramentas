package br.com.carpal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Empresa;
import br.com.carpal.model.Funcionario;
import br.com.carpal.model.dto.FuncionarioNewDTO;
import br.com.carpal.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	/* Salvar */
	public Funcionario salvar(Funcionario obj) {
		return repository.save(obj);

	}

	/* Salvando o Funcionario e Suas Referencias */
	public Funcionario fromDTO(FuncionarioNewDTO objDTO) {

		Cargo cargo = objDTO.getCargo();
		Empresa empresa = objDTO.getEmpresa();

		Funcionario Funcionario = new Funcionario(null, objDTO.getMatricula(), objDTO.getNome(), objDTO.getCpf(),
				objDTO.getContato(), cargo, empresa);

		return Funcionario;

	}

	/* Listar Todos */
	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Funcionario buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* Buscar por nome */
	public List<Funcionario> buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	/* Delete */
	public void remove(Long id) {
		Funcionario obj = new Funcionario();
		obj.setCodigo(id);
		repository.delete(id);

	}

}
