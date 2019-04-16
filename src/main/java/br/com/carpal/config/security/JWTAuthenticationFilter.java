package br.com.carpal.config.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.carpal.model.dto.CredenciaisDTO;

/*
 * filtro de autenticação  - de Login
 * */

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	protected AuthenticationManager authenticationManager;

	private JWTUtil jwtUtil;

	/* Construtor da Class */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {		
		
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	/* tenta autencicar */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

		try {
			CredenciaisDTO creds = new ObjectMapper().readValue(req.getInputStream(), CredenciaisDTO.class);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getCpf(),
					creds.getSenha(), new ArrayList<>());

			Authentication auth = authenticationManager.authenticate(authToken); // verifica se o usuario e senha são validos.
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* se autenticação for bem sucedido é chamado. */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		String cpf = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(cpf);
		res.addHeader("Authorization", "Bearer " + token);
		
		res.addHeader("access-control-expose-headers", "Authorization"); // libera a Leitura do cabeçalho personalizado Authorization por CORS
		
	}

}
