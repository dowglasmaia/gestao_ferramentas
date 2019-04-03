package br.com.carpal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Ferramenta;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class FerramentaRepository extends AbstractRepository<Ferramenta, Long> {

	/* Buscar Por Nome com IgnoreCase " */
	public List<Ferramenta> findByNome(String descricao) {
		return createDinamicQuery("select f from Ferramenta f where lower(f.descricao) like concat('%',lower(?1),'%')", descricao);

	}

}
