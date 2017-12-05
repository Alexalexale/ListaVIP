package listaconvidados.repository;

import org.springframework.data.repository.CrudRepository;

import listaconvidados.model.Eventos;

public interface EventoRepository extends CrudRepository<Eventos, Long> {

}
