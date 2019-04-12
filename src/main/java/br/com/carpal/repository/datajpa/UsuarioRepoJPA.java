package br.com.carpal.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.carpal.model.Usuario;

@Repository
public interface UsuarioRepoJPA extends JpaRepository<Usuario, Long>{
	
	@Transactional(readOnly = true)
	Usuario findByCpf(String cpf);

}
