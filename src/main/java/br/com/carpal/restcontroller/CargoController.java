package br.com.carpal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
