package br.com.carpal.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carpal.model.Locacao;
import br.com.carpal.model.LocacaoDetalhes;
import br.com.carpal.repository.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository repository;

	@Autowired
	private FerramentaService fmService;
	
	@Autowired
	private UsuarioService usuarioService;

	/* Salvar nova Requisição com os Datalhes */
	public Locacao salvar(Locacao obj) {
		obj.setCodigo(null);
		obj.setDataHoraLocIn(LocalDateTime.now());
		obj.setSituacao(obj.getSituacao().A);		

		/* inserindo os detalhes  na Requisição de Locação*/
		for (LocacaoDetalhes dt : obj.getLocacaoDetalhes()) {
			dt.setFerramenta(fmService.buscarPorID(dt.getFerramenta().getCodigo()));
			dt.setLocacao(obj);
		}		
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
