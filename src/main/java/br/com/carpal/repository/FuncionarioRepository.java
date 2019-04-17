package br.com.carpal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Funcionario;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class FuncionarioRepository extends AbstractRepository<Funcionario, Long> {

	/*
	 * Buscar Por Nome com IgnoreCase "não direncia letas MAIUSCULAS DE minusculas"
	 */
	public List<Funcionario> findByNome(String nome) {
		return createDinamicQuery("select f from Funcionario f where lower(f.nome) like concat('%',lower(?1),'%')", nome);

	}

}
