package br.com.carpal;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.carpal.model.Cargo;
import br.com.carpal.model.Empresa;
import br.com.carpal.model.Fabricante;
import br.com.carpal.model.Ferramenta;
import br.com.carpal.model.Funcionario;
import br.com.carpal.model.Locacao;
import br.com.carpal.model.LocacaoDetalhes;
import br.com.carpal.model.Usuario;
import br.com.carpal.model.enums.Perfil;
import br.com.carpal.model.enums.Situacao;
import br.com.carpal.repository.FuncionarioRepository;
import br.com.carpal.repository.LocacaoDetalhesRepository;
import br.com.carpal.repository.LocacaoRepository;
import br.com.carpal.services.CargoService;
import br.com.carpal.services.EmpresaService;
import br.com.carpal.services.FabricanteService;
import br.com.carpal.services.FerramentaService;
import br.com.carpal.services.FuncionarioService;
import br.com.carpal.services.UsuarioService;

@SpringBootApplication
public class GestaoFerramentasApplication implements CommandLineRunner {

	@Autowired
	BCryptPasswordEncoder pe;

	@Autowired
	private CargoService cargoService;

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	private FerramentaService fmService;

	@Autowired
	private UsuarioService userService;

	@Autowired
	private FuncionarioService funcService;

	@Autowired
	private EmpresaService empService;

	@Autowired
	private LocacaoRepository LocRepository;

	@Autowired
	private LocacaoDetalhesRepository LocDetalhes;

	public static void main(String[] args) {
		SpringApplication.run(GestaoFerramentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/* ================== Testando ================== ================== */

		Fabricante f1 = new Fabricante(null, "CNH", "www.cnh.com.br");
		fabricanteService.salvar(f1);

		Ferramenta fm1 = new Ferramenta(null, "NM Parafusos", "montador", 250, "Usar para Remover Prego", 10, 20, 500.0, f1);
		fmService.salvar(fm1);
		Ferramenta fm2 = new Ferramenta(null, "Martelo cabeça", "Prego", 600, "Usar para Remover Teto", 10, 50, 50.0,
				f1);
		fmService.salvar(fm2);
		Ferramenta fm3 = new Ferramenta(null, "NM Test03", "Chave de Trator", 250, "Usar para Remover Prego", 10, 20, 500.0, f1);
		fmService.salvar(fm3);

		Cargo c1 = new Cargo(null, "Assessor de TI");
		Cargo c2 = new Cargo(null, "Analista de TI");

		Empresa ep1 = new Empresa(null, 120, "Goiania", "012332123");
		Empresa ep2 = new Empresa(null, 025, "Goias", "012332123");
		Empresa ep3 = new Empresa(null, 001, "Anapolis", "012332123");
		Empresa ep4 = new Empresa(null, 789, "Imtubiara", "012332123");

		Funcionario fun1 = new Funcionario(null, 350, "Kayron Maia", "08277376022", "01-0000-0001", c1, ep2);

		Usuario user1 = new Usuario(null, 789, "Kayron Maia", "17288281043", "011-0320-0000", c1, ep1, pe.encode("123"));

		Usuario user2 = new Usuario(null, 001, "Dowglas Maia", "00668963395", "011-0320-0000", c2, ep1,
				pe.encode("123"));
		user2.addPerfil(Perfil.ADMIN); // Usuario Administrador

		c1.getUsuarios().add(user1);
		c2.getUsuarios().add(user2);

		c1.getFuncionario().add(fun1);

		ep1.getUsuarios().add(user1);
		ep4.getUsuarios().add(user2);

		ep1.getFuncionario().add(fun1);

		cargoService.salvar(c1);
		cargoService.salvar(c2);

		empService.salvar(ep1);
		empService.salvar(ep2);
		empService.salvar(ep3);
		empService.salvar(ep4);

		funcService.salvar(fun1);

		userService.salvar(user1);
		userService.salvar(user2);

		Locacao lc1 = new Locacao(null, LocalDateTime.now(), null, Situacao.A, fun1);
		LocRepository.save(lc1);

		LocacaoDetalhes dt1 = new LocacaoDetalhes(lc1, fm1, 2);
		LocacaoDetalhes dt2 = new LocacaoDetalhes(lc1, fm2, 1);

		lc1.getLocacaoDetalhes().addAll(Arrays.asList(dt1, dt2));

		fm1.getLocacaoDetalhes().addAll(Arrays.asList(dt1));
		fm2.getLocacaoDetalhes().addAll(Arrays.asList(dt1));

		LocDetalhes.save(dt1);
		LocDetalhes.save(dt2);

	}

}
