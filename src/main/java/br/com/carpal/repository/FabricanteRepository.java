package br.com.carpal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Fabricante;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class FabricanteRepository extends AbstractRepository<Fabricante, Long> {

	// Buscar Por Nome Usando a Create Quere criada no AbatractDAO
	public List<Fabricante> findByNome(String nome) {
		return createDinamicQuery("select f from Fabricante f where f.nome like concat('%',?1,'%')", nome);

	}

}
