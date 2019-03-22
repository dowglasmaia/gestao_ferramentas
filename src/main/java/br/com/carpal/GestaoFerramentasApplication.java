package br.com.carpal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.carpal.model.Cargo;
import br.com.carpal.services.CargoService;

@SpringBootApplication
public class GestaoFerramentasApplication implements CommandLineRunner {

	@Autowired
	private CargoService cargoService;

	public static void main(String[] args) {
		SpringApplication.run(GestaoFerramentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo c1 = new Cargo(null, "Assessor de TI");
		Cargo c2 = new Cargo(null, "Analista de TI");
		
		cargoService.salvar(c1);
		cargoService.salvar(c2);

	}

}
