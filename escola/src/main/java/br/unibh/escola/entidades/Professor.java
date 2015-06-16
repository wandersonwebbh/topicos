package br.unibh.escola.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
@PrimaryKeyJoinColumn
@Table(name = "TB_PROFESSOR", uniqueConstraints = @UniqueConstraint(columnNames = "salario"))
@NamedQueries({ @NamedQuery(name = "Professor.findByName", query = "select p from Professor p where p.nome like :nome") })
public class Professor extends Pessoa {

@NotNull
@DecimalMin(value = "500", message="minimo R$ 500,00")
@DecimalMax(value = "50000", message="maximo R$ 50,000")
@Column(name = "salario", columnDefinition = "Decimal(10,2)")
private BigDecimal salario;
public static Double BONUS = 0.10D;

@OneToMany(fetch=FetchType.EAGER, mappedBy="professor")
private List<Disciplina> disciplinas;

public Professor() {
}

public Professor(Long id, String nome, String cpf, BigDecimal salario) {
	super(id, nome, cpf);
	this.salario = salario;
}

public Professor(Long id, String nome, String cpf) {
	super(id, nome, cpf);
}

public BigDecimal getSalario() {
	return salario;
}

public void setSalario(BigDecimal salario) {
	this.salario = salario;
}

public static Double getBONUS() {
	return BONUS;
}

public static void setBONUS(Double bONUS) {
	BONUS = bONUS;
}

public List<Disciplina> getDisciplinas() {
	return disciplinas;
}

public void setDisciplinas(List<Disciplina> disciplinas) {
	this.disciplinas = disciplinas;
}

@Override
public String toString() {
	return "Professor [salario=" + salario + ", disciplinas=" + disciplinas
			+ "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((salario == null) ? 0 : salario.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Professor other = (Professor) obj;
	if (salario == null) {
		if (other.salario != null)
			return false;
	} else if (!salario.equals(other.salario))
		return false;
	return true;
}

}