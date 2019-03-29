package br.com.carpal.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Cargo;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class CargoRepository extends AbstractRepository<Cargo, Long> {
	
	/* Buscar Por Nome com IgnoreCase "não direncia letas MAIUSCULAS DE minusculas" */
	public List<Cargo> findByNome(String nome) {
		return createDinamicQuery("select f from Cargo f where lower(f.nome) like concat('%',lower(?1),'%')", nome);

	}

}
