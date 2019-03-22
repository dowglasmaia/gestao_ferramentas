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

import br.com.carpal.model.Modelo;
import br.com.carpal.services.ModeloService;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

	@Autowired
	private ModeloService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Modelo>> listarTodos() {
		List<Modelo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Modelo buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}

	@PostMapping
	public Modelo salvar(@RequestBody Modelo obj) {
		return service.salvar(obj);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
