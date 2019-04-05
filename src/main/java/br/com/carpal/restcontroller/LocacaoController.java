package br.com.carpal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carpal.model.Locacao;
import br.com.carpal.services.LocacaoService;

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
	public Locacao buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}

	/* Buscar por nome - como paramentro
	@GetMapping("/usuario")
	public ResponseEntity<List<Locacao>> findByUsuario(@RequestParam(value = "nome") String nome) {
		List<Locacao> list = service.findByUsuarios(nome);
		return ResponseEntity.ok().body(list);
	}
	*/
	
	/*Salvando a Localçao*/
	@PostMapping
	public Locacao salvar(@RequestBody Locacao locacao) {
		return service.salvar(locacao);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
