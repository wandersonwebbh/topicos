package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

	@Entity
	@PrimaryKeyJoinColumn
	@Table(name = "TB_PROFESSOR", uniqueConstraints = @UniqueConstraint(columnNames = "salario"))
	@NamedQueries({ @NamedQuery(name="Professor.findByName", query = "select a from Professor a where a.nome like :nome")})
	public class Professor extends Pessoa {
	@NotNull
	@DecimalMin(value = "500")
	@DecimalMax(value = "50000")
	@Column(name = "salario", nullable = false)	
	private BigDecimal salario;
	
	@Transient
	public static Double BONUS = 0.1D;

	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}
	public Professor(){		
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString() + "Professor [salario=" + salario + "]";
	}

}
