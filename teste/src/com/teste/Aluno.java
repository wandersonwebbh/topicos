package com.teste;

import java.util.Date;

public class Aluno extends Pessoa {
	private Long matricula;
	private Date dataAniversario;

	public Aluno(String nome, String cpf, Long matricula, Date dataAniversario) {
		super(nome, cpf);
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

	@Override
	public String toString() {
		return super.toString()+"Aluno [matricula=" + matricula + ", dataAniversario="
				+ dataAniversario + "]";
	}

}