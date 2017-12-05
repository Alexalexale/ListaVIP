package listaconvidados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import listaconvidados.model.Eventos;
import listaconvidados.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;

	public Iterable<Eventos> obterTodos() {

		Iterable<Eventos> convidados = repository.findAll();

		return convidados;

	}

	public void salvar(Eventos convidado) {
		repository.save(convidado);
	}

	public Eventos find(long id) {
		return repository.findOne(id);
	}
}
