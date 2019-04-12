package br.com.carpal.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	/* pegando os dados do application.properties */
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	/* Gerando Token - com o Usuario, e tempo de expiração */
	public String generateToken(String cpf) {
		return Jwts.builder()
		.setSubject(cpf) // Usuario
		.setExpiration(new Date(System.currentTimeMillis() + expiration)) // tempo de expiranção
		.signWith(SignatureAlgorithm.HS512, secret.getBytes()) // algoritimo de Cryptografia +  a palavra secreta criada, garantindo uma token mas seguro.
		.compact();
	}

}
