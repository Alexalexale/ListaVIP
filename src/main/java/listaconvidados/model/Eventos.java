package listaconvidados.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Eventos implements Serializable {

	private static final long serialVersionUID = 1209918737477196722L;

	private Long id;
	private String descricao;
	private String email;
	private Set<Convidado> convidados;

	public Eventos() {

	}

	public Eventos(String descricao, String email) {
		this.descricao = descricao;
		this.email = email;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	public Set<Convidado> getConvidados() {
		return convidados;
	}

	public void setConvidados(Set<Convidado> convidados) {
		this.convidados = convidados;
	}

}