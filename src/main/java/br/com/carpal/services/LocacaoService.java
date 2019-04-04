package br.com.carpal.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import br.com.carpal.model.Ferramenta;
import br.com.carpal.model.Locacao;
import br.com.carpal.model.LocacaoDetalhes;
import br.com.carpal.model.Usuario;
import br.com.carpal.model.dto.LocacaoDTO;
import br.com.carpal.repository.LocacaoDetalhesRepository;
import br.com.carpal.repository.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository repository;

	@Autowired
	private LocacaoDetalhesRepository lcDetalhesRepo;

	@Autowired
	private UsuarioService service;

	@Autowired
	private FerramentaService fmService;

	/* Salvar */
	public Locacao salvar(Locacao obj) {
		
		/*Salvando Uma nova requisição */

		obj.setCodigo(null);
		obj.setDataHoraLocIn(LocalDateTime.now());
		obj.setDataHoraLocEnd(null);
		obj.setSituacao(obj.getSituacao().A);
		
		obj.setUsuarioLogado(service.buscarPorID(obj.getUsuarioLogado().getCodigo()));
		obj.setUsuarioRequerent(service.buscarPorID(obj.getUsuarioRequerent().getCodigo()));

		for (LocacaoDetalhes dt : obj.getLocacaoDetalhes()) {
			dt.setQuantidade(dt.getQuantidade());
			dt.setFerramenta(fmService.buscarPorID(dt.getFerramenta().getCodigo()));
			dt.setLocacao(obj);

			obj.getLocacaoDetalhes().add(dt);
		}		
		
		/*Atualizando Uma requisição - Para Fechada/Baixada */
		
		return repository.save(obj);

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

}
