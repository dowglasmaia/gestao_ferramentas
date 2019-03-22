package br.com.carpal.repository;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Ferramenta;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class FerramentaRepository extends AbstractRepository<Ferramenta, Long> {

}
