package br.com.carpal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Empresa;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class EmpresaRepository extends AbstractRepository<Empresa, Long> {

	/* Buscar Por Nome com IgnoreCase "não direncia letas MAIUSCULAS DE minusculas" */
	public List<Empresa> findByNome(String nome) {
		return createDinamicQuery("select f from Empresa f where lower(f.nome) like concat('%',lower(?1),'%')", nome);

	}
}
