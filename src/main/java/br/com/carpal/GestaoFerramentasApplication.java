package br.com.carpal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Fabricante;
import br.com.carpal.model.Ferramenta;
import br.com.carpal.services.CargoService;
import br.com.carpal.services.FabricanteService;
import br.com.carpal.services.FerramentaService;

@SpringBootApplication
public class GestaoFerramentasApplication implements CommandLineRunner {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	private FerramentaService fmService;

	public static void main(String[] args) {
		SpringApplication.run(GestaoFerramentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo c1 = new Cargo(null, "Assessor de TI");
		Cargo c2 = new Cargo(null, "Analista de TI");
		cargoService.salvar(c1);
		cargoService.salvar(c2);

		Fabricante f1 = new Fabricante(null, "CNH", "www.cnh.com.br");
		fabricanteService.salvar(f1);

		/* Ferramentas */
		Ferramenta fm1 = new Ferramenta(null, "NM Test01", "tes01", 250, "Usar para Remover Prego", 20, 500.0, f1, null, null);

		fmService.salvar(fm1);

		Ferramenta fm2 = new Ferramenta(null, "NM Test02", "tes02", 250, "Usar para Remover Teto", 20, 50.0, f1, null, null);

		fmService.salvar(fm2);

		Ferramenta fm3 = new Ferramenta(null, "NM Test03", "tes03", 250, "Usar para Remover Prego", 20, 500.0, f1, null, null);

		fmService.salvar(fm3);

	}

}
