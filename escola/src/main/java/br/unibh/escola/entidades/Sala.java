package br.unibh.escola.entidades;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_SALA")
@NamedQueries({ @NamedQuery(name = "Sala.findByCapacidade", query = "select s from Sala s where s.capacidade >= :capacidade") })
public class Sala {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@NotNull
@Column(name = "codigo", length = 10, nullable = false, unique = true)
private String codigo;

@NotNull
@Column(name = "capacidade", nullable = false)
private int capacidade;


@Column(name="possuiQuadroBranco", nullable=false) 
private boolean possuiQuadroBranco;

@Column(name="possuiDataShow", nullable=false)
private boolean possuiDataShow;

@Column(name="possuiComputador", nullable=false)
private boolean possuiComputador;

@Column(name = "observacao", length = 255, nullable = true)
private String observacao;

@NotNull
@Column(name="status")
private int status;

@Column(name="dataTerminoManutencao", nullable=true)
@Temporal(value = TemporalType.DATE)
private Date dataTerminoManutencao;

@Version
private int versao;

@OneToMany(fetch=FetchType.EAGER, mappedBy="sala")
private List<Disciplina> disciplinas;

public Sala(){}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public int getCapacidade() {
	return capacidade;
}

public void setCapacidade(int capacidade) {
	this.capacidade = capacidade;
}

public boolean ispossuiQuadroBranco() {
	return possuiQuadroBranco;
}

public void setpossuiQuadroBranco(boolean possuiQuadroBranco) {
	this.possuiQuadroBranco = possuiQuadroBranco;
}

public boolean ispossuiDataShow() {
	return possuiDataShow;
}

public void setpossuiDataShow(boolean possuiDataShow) {
	this.possuiDataShow = possuiDataShow;
}

public boolean ispossuiComputador() {
	return possuiComputador;
}

public void setpossuiComputador(boolean possuiComputador) {
	this.possuiComputador = possuiComputador;
}

public String getObservacao() {
	return observacao;
}

public void setobservacao(String observacao) {
	this.observacao = observacao;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public Date getdataTerminoManutencao() {
	return dataTerminoManutencao;
}

public void setdataTerminoManutencao(Date dataTerminoManutencao) {
	this.dataTerminoManutencao = dataTerminoManutencao;
}


public List<Disciplina> getDisciplinas() {
	return disciplinas;
}


public void setDisciplinas(List<Disciplina> disciplinas) {
	this.disciplinas = disciplinas;
}


@Override
public String toString() {
	return "Sala [id=" + id + ", codigo=" + codigo + ", capacidade="
			+ capacidade + ", possuiQuadroBranco=" + possuiQuadroBranco + ", possuiDataShow=" + possuiDataShow
			+ ", possuiComputador=" + possuiComputador + ", observacao=" + observacao + ", status="
			+ status + ", dataTerminoManutencao=" + dataTerminoManutencao
			+ ", versao=" + versao + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + capacidade;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	result = prime
			* result
			+ ((dataTerminoManutencao == null) ? 0 : dataTerminoManutencao
					.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result
			+ ((observacao == null) ? 0 : observacao.hashCode());
	result = prime * result + (possuiComputador ? 1231 : 1237);
	result = prime * result + (possuiDataShow ? 1231 : 1237);
	result = prime * result + (possuiQuadroBranco ? 1231 : 1237);
	result = prime * result + status;
	result = prime * result + versao;
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
	Sala other = (Sala) obj;
	if (capacidade != other.capacidade)
		return false;
	if (codigo == null) {
		if (other.codigo != null)
			return false;
	} else if (!codigo.equals(other.codigo))
		return false;
	if (dataTerminoManutencao == null) {
		if (other.dataTerminoManutencao != null)
			return false;
	} else if (!dataTerminoManutencao.equals(other.dataTerminoManutencao))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (observacao == null) {
		if (other.observacao != null)
			return false;
	} else if (!observacao.equals(other.observacao))
		return false;
	if (possuiComputador != other.possuiComputador)
		return false;
	if (possuiDataShow != other.possuiDataShow)
		return false;
	if (possuiQuadroBranco != other.possuiQuadroBranco)
		return false;
	if (status != other.status)
		return false;
	if (versao != other.versao)
		return false;
	return true;
}




}
