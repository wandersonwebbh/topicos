package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_SALA")
@NamedQuery(name="Sala.findBycapacidade", query = "select a from Sala a where a.capacidade >= :capacidade")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message="Não pode ser null")
	@Column(name = "codigo", length=10,nullable=false)
	private String codigo;

	@NotNull(message="Não pode ser null")
	@Column(name = "capacidade", nullable=false)
	private Integer capacidade;

	private Boolean possuiQuadroBranco;

	private Boolean possuiDataShow;

	private Boolean possuiComputador;

	@Column(name = "observacao", length=255)
	private String observacao;
	
	@NotNull(message="Não pode ser null")
	@Column(nullable=false)
	private Integer status;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataTerminoManutencao")
	private Date dataTerminoManutencao;

	public Long getId() {
		return id;
	}

	public Sala() {
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

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Boolean getPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}

	public void setPossuiQuadroBranco(Boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}

	public Boolean getPossuiDataShow() {
		return possuiDataShow;
	}

	public void setPossuiDataShow(Boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}

	public Boolean getPossuiComputador() {
		return possuiComputador;
	}

	public void setPossuiComputador(Boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	public Sala(Long id, String codigo, Integer capacidade,
			Boolean possuiQuadroBranco, Boolean possuiDataShow,
			Boolean possuiComputador, String observacao, Integer status,
			Date dataTerminoManutencao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.capacidade = capacidade;
		this.possuiQuadroBranco = possuiQuadroBranco;
		this.possuiDataShow = possuiDataShow;
		this.possuiComputador = possuiComputador;
		this.observacao = observacao;
		this.status = status;
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", codigo=" + codigo + ", capacidade="
				+ capacidade + ", possuiQuadroBranco=" + possuiQuadroBranco
				+ ", possuiDataShow=" + possuiDataShow + ", possuiComputador="
				+ possuiComputador + ", observacao=" + observacao + ", status="
				+ status + ", dataTerminoManutencao=" + dataTerminoManutencao
				+ ", getId()=" + getId() + ", getCodigo()=" + getCodigo()
				+ ", getCapacidade()=" + getCapacidade()
				+ ", getPossuiQuadroBranco()=" + getPossuiQuadroBranco()
				+ ", getPossuiDataShow()=" + getPossuiDataShow()
				+ ", getPossuiComputador()=" + getPossuiComputador()
				+ ", getObservacao()=" + getObservacao() + ", getStatus()="
				+ getStatus() + ", getDataTerminoManutencao()="
				+ getDataTerminoManutencao() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
