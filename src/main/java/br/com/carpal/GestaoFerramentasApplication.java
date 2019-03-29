package br.com.carpal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Empresa;
import br.com.carpal.model.Fabricante;
import br.com.carpal.model.Ferramenta;
import br.com.carpal.model.Usuario;
import br.com.carpal.services.CargoService;
import br.com.carpal.services.EmpresaService;
import br.com.carpal.services.FabricanteService;
import br.com.carpal.services.FerramentaService;
import br.com.carpal.services.UsuarioService;

@SpringBootApplication
public class GestaoFerramentasApplication implements CommandLineRunner {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	private FerramentaService fmService;
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private EmpresaService empService;

	public static void main(String[] args) {
		SpringApplication.run(GestaoFerramentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*================== Testando ================== */		

		/*================== */
		Fabricante f1 = new Fabricante(null, "CNH", "www.cnh.com.br");
		fabricanteService.salvar(f1);

		/*================== */
		Ferramenta fm1 = new Ferramenta(null, "NM Test01", "tes01", 250, "Usar para Remover Prego", 10, 20, 500.0, f1);
		fmService.salvar(fm1);
		Ferramenta fm2 = new Ferramenta(null, "NM Test02", "tes02", 250, "Usar para Remover Teto", 10, 20, 50.0, f1);
		fmService.salvar(fm2);
		Ferramenta fm3 = new Ferramenta(null, "NM Test03", "tes03", 250, "Usar para Remover Prego", 10, 20, 500.0, f1);
		fmService.salvar(fm3);
		/*================== */	
		

		Cargo c1 = new Cargo(null, "Assessor de TI");
		Cargo c2 = new Cargo(null, "Analista de TI");
		
		Empresa ep1 = new Empresa(null, "Goiania", "012332123");		

		Usuario user1 = new Usuario(null, 320, "Maia", "012", "986", c1, ep1);
		
		c1.getUsuarios().add(user1);
		ep1.getUsuarios().add(user1);
		
		cargoService.salvar(c1);
		cargoService.salvar(c2);		
		empService.salvar(ep1);
		userService.salvar(user1);
		
		/*================== */	
		
		
		
		
		

	}

}
