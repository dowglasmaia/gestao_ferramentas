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

import br.com.carpal.model.Ferramenta;
import br.com.carpal.services.FerramentaService;

@RestController
@RequestMapping("/ferramentas")
public class FerramentasController {

	@Autowired
	private FerramentaService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Ferramenta>> listarTodos() {
		List<Ferramenta> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Ferramenta buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}

	@PostMapping
	public Ferramenta salvar(@RequestBody Ferramenta Ferramenta) {
		return service.salvar(Ferramenta);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
