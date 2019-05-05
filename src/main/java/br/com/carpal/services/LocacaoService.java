package br.com.carpal.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import br.com.carpal.model.Locacao;
import br.com.carpal.model.LocacaoDetalhes;
import br.com.carpal.repository.LocacaoRepository;
import br.com.carpal.repository.datajpa.LocacaoRepoJPA;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository repository;

	@Autowired
	private FerramentaService fmService;

	@Autowired
	private LocacaoRepoJPA locaRepo;

	@Autowired
	private UsuarioService usuarioService;

	/* conexão para relatorio */
	@Autowired
	private EntityManager entityManager;

	/* Salvar nova Requisição com os Datalhes */
	public Locacao salvar(Locacao obj) {

		obj.setDataHoraLocIn(LocalDateTime.now());
		obj.setSituacao(obj.getSituacao().A);
		/* inserindo os detalhes na Requisição de Locação */
		for (LocacaoDetalhes dt : obj.getLocacaoDetalhes()) {
			dt.setFerramenta(fmService.buscarPorID(dt.getFerramenta().getCodigo()));

			/* Removendo Ferramenta do estoque apos salvar a Requisição */
			dt.getFerramenta().setEstoque(dt.getFerramenta().getEstoque() - dt.getQuantidade());
			dt.setLocacao(obj);

		}
		return locaRepo.save(obj);

	}

	/* Listar Todos */
	public List<Locacao> findAll() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Locacao buscarPorID(Long id) {
		return repository.findById(id);
	}

	/* Lista de Locações Por Usuario */
	public List<Locacao> findByUsuarios() {
		// impl logica
		return null;
	}

	/* Delete */
	public void remove(Long id) {
		Locacao obj = new Locacao();
		obj.setCodigo(id);
		repository.delete(id);

	}

	/* Relatorio de Requisição - Jasper */
	public InputStream relatorio() throws Exception {

		/* Definindo o Nome do arquivo */
		File relatorio = File.createTempFile("requisicao", "pdf");

		/* instanciando um Session apartin de Uma EntityManager */
		Session session = (Session) entityManager.getDelegate();
		session.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				try {

					/* Arquivo Jasper - Gerado */
					File jasper = ResourceUtils.getFile("classpath:relatorios/requisicao.jasper");

					/* Gerando o Relatorio */
					JasperPrint print = JasperFillManager.fillReport(jasper.getAbsolutePath(), null, connection);

					/* Exportando para PDF */
					JasperExportManager.exportReportToPdfFile(print, relatorio.getAbsolutePath());

				} catch (JRException | FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		return new FileInputStream(relatorio);
	}

	/* Locação Update - Baixar Requisição */
	public Locacao update(Locacao obj) {
		Locacao newObj = buscarPorID(obj.getCodigo());		
		 updateData(newObj, obj);		
		return locaRepo.save(newObj);

	}

	// metodo auxilar para atualizar
	private void updateData(Locacao newObj, Locacao obj) {
		newObj.setDataHoraLocEnd(LocalDateTime.now()); // Baixar a Requisição com a Hora do Sistema.
		newObj.setSituacao(obj.getSituacao().F); // Fechar a Requisição.
		
	}

}
