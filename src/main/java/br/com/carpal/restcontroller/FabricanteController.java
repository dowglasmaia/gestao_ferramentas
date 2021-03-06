package br.com.carpal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.carpal.model.Fabricante;
import br.com.carpal.services.FabricanteService;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Fabricante>> listarTodos() {
		List<Fabricante> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Fabricante buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}
	
	/* Buscar por nome - como paramentro*/
	@GetMapping("/name")
	public ResponseEntity<List<Fabricante>> findByName(@RequestParam(value = "nome") String nome) {
		List<Fabricante> list = service.buscarPorNome(nome);
		return ResponseEntity.ok().body(list);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public Fabricante salvar(@RequestBody Fabricante obj) {
		return service.salvar(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')") // SOMENTE Admin pode Excluir
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
