package br.com.carpal.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carpal.model.Locacao;
import br.com.carpal.services.LocacaoService;
import br.com.carpal.services.exceptions.FileException;

@RestController
@RequestMapping("/requisicoes")
public class LocacaoController {

	@Autowired
	private LocacaoService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Locacao>> listarTodos() {
		List<Locacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Locacao> buscarPorId(@PathVariable Long id) {
		Locacao obj = service.buscarPorID(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * Buscar por nome - como paramentro
	 * 
	 * @GetMapping("/usuario") public ResponseEntity<List<Locacao>>
	 * findByUsuario(@RequestParam(value = "nome") String nome) { List<Locacao> list
	 * = service.findByUsuarios(nome); return ResponseEntity.ok().body(list); }
	 */

	/* Salvando a Localçao */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public Locacao salvar(@RequestBody Locacao locacao) {
		return service.salvar(locacao);
	}

	@PreAuthorize("hasAnyRole('ADMIN')") // SOMENTE Admin pode Excluir
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

	/* Endpoint - Relatorio */
	@GetMapping("/relatorio")
	public void findRelatorio(HttpServletResponse response) {
		try {
			IOUtils.copy(service.relatorio(), response.getOutputStream());
			
			//Setando o Tipo de arquivo para a Aplicação Cliente(Navegador"
			response.setContentType("application/pdf");
			
			//enviando os Dados na Resposta da requisição
			response.flushBuffer();			
		} catch (Exception e) {
			throw new FileException(e.getMessage());
		}
	}

}
