package br.com.carpal.repository;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Modelo;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class ModeloRepository extends AbstractRepository<Modelo, Long> {

}
