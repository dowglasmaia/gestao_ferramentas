package br.com.carpal.config.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.carpal.model.enums.Perfil;

/**
 * @author Dowglas Maia
 * 
 */

public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;

	/* Credencias de login para autenticação */
	private Long codigo;
	private String cpf;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS() {

	}

	public UserSS(Long codigo, String cpf, String senha, Set<Perfil> perfils) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.senha = senha;
		/*
		 * convertendo a lista de perfis para uma Collection de authorities - pegando os
		 * pefis para o Sprg Security
		 */
		this.authorities = perfils.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
										   .collect(Collectors.toSet());
	}

	public Long getCodigo() {
		return codigo;
	}

	/* Autorizações */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/* Senha */
	@Override
	public String getPassword() {
		return senha;
	}

	/* login - cpf */
	@Override
	public String getUsername() {
		return cpf;
	}

	/* Validação de Conta, Expirado ou não. */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* Validação de Conta, Se estar Bloqueada */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* Valida se asCredencias estão espiradas. */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/* Valida se o usuario estar ativo. */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
