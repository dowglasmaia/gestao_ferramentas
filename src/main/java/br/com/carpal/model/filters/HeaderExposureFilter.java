package br.com.carpal.model.filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**@author Dowglas Maia 
 *Tornando o Header location Visivel - para que minha aplicação Angular tenha acesso a este cabeçalho
 **/

@Component
public class HeaderExposureFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("access-control-expose-headers", "location"); // libera a Leitura Cabeçalho do Location
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
