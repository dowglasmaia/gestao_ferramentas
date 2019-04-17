package br.com.carpal.restcontroller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.carpal.model.Funcionario;
import br.com.carpal.model.dto.FuncionarioNewDTO;
import br.com.carpal.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarTodos() {
		List<Funcionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Funcionario buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}

	/* Buscar por nome - como paramentro */
	@GetMapping("/name")
	public ResponseEntity<List<Funcionario>> findByName(@RequestParam(value = "nome") String nome) {
		List<Funcionario> list = service.buscarPorNome(nome);
		return ResponseEntity.ok().body(list);
	}


	/* Salvar */
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody FuncionarioNewDTO objDTO) {
		Funcionario obj = service.fromDTO(objDTO);
		service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')") // SOMENTE Admin pode Excluir
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
