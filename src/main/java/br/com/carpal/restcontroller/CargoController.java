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

import br.com.carpal.model.Cargo;
import br.com.carpal.services.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Cargo>> listarTodos() {
		List<Cargo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Cargo buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}
	
	/* Buscar por nome - como paramentro*/
	@GetMapping("/name")
	public ResponseEntity<List<Cargo>> findByName(@RequestParam(value = "nome") String nome) {
		List<Cargo> list = service.buscarPorNome(nome);
		return ResponseEntity.ok().body(list);
	}

	@PreAuthorize("hasAnyRole('ADMIN')") 
	@PostMapping
	public Cargo salvar(@RequestBody Cargo cargo) {
		return service.salvar(cargo);
	}

	@PreAuthorize("hasAnyRole('ADMIN')") // SOMENTE Admin pode Excluir
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
