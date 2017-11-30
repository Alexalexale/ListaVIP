package listaconvidados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import listaconvidados.model.Evento;
import listaconvidados.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;

	public Iterable<Evento> obterTodos() {

		Iterable<Evento> convidados = repository.findAll();

		return convidados;

	}

	public void salvar(Evento convidado) {
		repository.save(convidado);
	}

	public Evento find(long id) {
		return repository.findOne(id);
	}
}
