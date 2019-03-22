package br.com.carpal.repository;

import org.springframework.stereotype.Repository;

import br.com.carpal.model.Locacao;
import br.com.carpal.repository.generic.AbstractRepository;

@Repository
public class LocacaoRepository extends AbstractRepository<Locacao, Long> {

}
