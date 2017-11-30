package listaconvidados.repository;

import org.springframework.data.repository.CrudRepository;

import listaconvidados.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {

}
