package br.com.carpal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Usuario;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class UsuarioRepository extends AbstractRepository<Usuario, Long> {

	/*
	 * Buscar Por Nome com IgnoreCase "não direncia letas MAIUSCULAS DE minusculas"
	 */
	public List<Usuario> findByNome(String nome) {
		return createDinamicQuery("select f from Usuario f where lower(f.nome) like concat('%',lower(?1),'%')", nome);

	}

	/* Buscar Por CPF */
	public List<Usuario> findByCpf(String cpf) {
		return createDinamicQuery("select f from Usuario f where f.cpf = ?1", cpf);
	}
}
