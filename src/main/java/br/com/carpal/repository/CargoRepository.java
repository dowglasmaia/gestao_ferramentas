package br.com.carpal.repository;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Cargo;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class CargoRepository extends AbstractRepository<Cargo, Long> {

}
