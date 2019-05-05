package br.com.carpal.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carpal.model.Locacao;

@Repository
public interface LocacaoRepoJPA extends JpaRepository<Locacao, Long>{
	
	

}
