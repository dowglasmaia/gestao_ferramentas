package br.com.carpal.repository;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Empresa;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class EmpresaRepository extends AbstractRepository<Empresa, Long> {

}
