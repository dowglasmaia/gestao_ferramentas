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

import br.com.carpal.model.Empresa;
import br.com.carpal.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Empresa>> listarTodos() {
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Empresa buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}

	@PostMapping
	public Empresa salvar(@RequestBody Empresa empresa) {
		return service.salvar(empresa);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
