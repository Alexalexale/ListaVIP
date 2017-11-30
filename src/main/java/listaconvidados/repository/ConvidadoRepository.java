package listaconvidados.repository;

import org.springframework.data.repository.CrudRepository;

import listaconvidados.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
