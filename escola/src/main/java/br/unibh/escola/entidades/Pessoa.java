package br.unibh.escola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@NotBlank
@NotNull
@Size(min = 5, max = 100)
@Pattern(regexp = "[A-Za-z À-ú ]*", message = "must contain only letters and spaces")
@Column(name = "nome", length = 100, nullable = false)
private String nome;

@NotBlank
@NotNull
@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message="formato correto (000.000.000-00)")
@Column(unique = true)
private String cpf;

public Pessoa(){}

public Pessoa(Long id, String nome, String cpf) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

@Override
public String toString() {
	return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pessoa other = (Pessoa) obj;
	if (cpf == null) {
		if (other.cpf != null)
			return false;
	} else if (!cpf.equals(other.cpf))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}
}
