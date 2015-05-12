package br.unibh.escola.visao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Sala;
import br.unibh.escola.negocio.ServicoSala;

@ManagedBean(name = "salamb")
@ViewScoped
public class ControleSala {

	@Inject
	private Logger log;
	@Inject
	private ServicoSala sa;
	private Sala sala;
	private String nomeArg;
	private Long id;
	private String codigo;
	private Integer capacidade;
	private Boolean possuiQuadroBranco;
	private Boolean possuiDataShow;
	private Boolean possuiComputador;
	private String observacao;
	private Integer status;
	private Date dataTerminoManutencao;
	private List<Sala> salaes;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	public Sala getSala() {
		return sala;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Sala> getSalaes() {
		return salaes;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Sala");
		try {
			salaes = sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (sala.getId() == null) {
				sala = sa.insert(sala);
			} else {
				sala = sa.update(sala);
			}
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "
					+ e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel",
					facesMsg);
			return;
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Sala gravado com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			
			salaes = sa.findBycapacidade(Integer.parseInt(nomeArg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		sala = new Sala();
	}

	public void cancelar() {
		sala = null;
	}

	public void editar() {
		try {
			sala = sa.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = null;
	}

	public void excluir() {
		try {
			sa.delete(sa.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = null;
	}
}