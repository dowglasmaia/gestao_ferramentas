package br.com.carpal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Fabricante;
import br.com.carpal.model.Modelo;
import br.com.carpal.services.CargoService;
import br.com.carpal.services.FabricanteService;
import br.com.carpal.services.ModeloService;

@SpringBootApplication
public class GestaoFerramentasApplication implements CommandLineRunner {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private FabricanteService fabricanteService;

	public static void main(String[] args) {
		SpringApplication.run(GestaoFerramentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo c1 = new Cargo(null, "Assessor de TI");
		Cargo c2 = new Cargo(null, "Analista de TI");		
		cargoService.salvar(c1);
		cargoService.salvar(c2);
		
		Modelo m1 = new Modelo(null, "NP_896");		
		modeloService.salvar(m1);
		
		Fabricante f1 = new Fabricante(null, "CNH", "www.cnh.com.br");
		fabricanteService.salvar(f1);
		
		

	}

}
