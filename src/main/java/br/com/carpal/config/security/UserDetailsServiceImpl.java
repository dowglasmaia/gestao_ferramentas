package br.com.carpal.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Usuario;
import br.com.carpal.repository.datajpa.UsuarioRepoJPA;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepoJPA repo;

	/*Buscando o usuario pelo Cpf e autenticando o mesmo.*/
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Usuario user = (Usuario) repo.findByCpf(cpf);
		if(user == null) {
			throw new UsernameNotFoundException(cpf);
		}		
		return new UserSS(user.getCodigo(), user.getCpf(), user.getSenha(), user.getPerfis());
	}

}
