package listaconvidados.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import listaconvidados.model.Convidado;
import listaconvidados.model.Evento;
import listaconvidados.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	@Autowired
	private EventoService eventoService;

	public Iterable<Convidado> obterTodos() {

		Iterable<Convidado> convidados = repository.findAll();

		return convidados;

	}

	public void salvar(Convidado convidado) {
		repository.save(convidado);
	}

	public Set<Convidado> findByEvento(Long idEvento) {
		Evento find = eventoService.find(idEvento);
		return find.getConvidados();
	}

}
