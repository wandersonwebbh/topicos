package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

	@Entity	@PrimaryKeyJoinColumn
	@Table(name="TB_ALUNO")
public class Aluno extends Pessoa {
		
	@NotBlank
	// falta colocar o formado da tada @Temporal ou  @past
	@Column(name="matricula", nullable=false, unique=true)	
	private Long matricula;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="data_aniversario", nullable=false)
	private Date dataAniversario;

	public Aluno(){		
	}
	public Aluno(Long id, String nome, String cpf, Long matricula,
			Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public static boolean verificaMatricula(String matricula) {
		if (matricula == null) {
			return false;
		} else if (matricula.trim().equals("")) {
			return false;
		} else if (matricula.length() != 8) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Aluno [matricula=" + matricula
				+ ", dataAniversario=" + dataAniversario + "]";
	}

}
