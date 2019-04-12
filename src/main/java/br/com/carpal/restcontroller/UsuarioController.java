package br.com.carpal.restcontroller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.carpal.model.Usuario;
import br.com.carpal.model.dto.UsuarioNewDTO;
import br.com.carpal.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return service.buscarPorID(id);
	}

	/* Buscar por nome - como paramentro */
	@GetMapping("/name")
	public ResponseEntity<List<Usuario>> findByName(@RequestParam(value = "nome") String nome) {
		List<Usuario> list = service.buscarPorNome(nome);
		return ResponseEntity.ok().body(list);
	}

	/* Buscar por cpf - como paramentro */
	@GetMapping("/cpf")
	public ResponseEntity<List<Usuario>> findByCpf(@RequestParam(value = "cpf") String cpf) {
		List<Usuario> list = service.buscarPorCpf(cpf);
		return ResponseEntity.ok().body(list);
	}

	/* Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody UsuarioNewDTO objDTO) {
		Usuario obj = service.fromDTO(objDTO);
		service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.remove(id);
	}

}
