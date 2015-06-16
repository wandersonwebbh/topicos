package br.unibh.escola.visao;

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
	private String capacidadeArg;
	private Long id;
	private List<Sala> salas;

	public Sala getSala() {
		return sala;
	}

	public String getCapacidadeArg() {
		return capacidadeArg;
	}

	public void setCapacidadeArg(String capacidadeArg) {
		this.capacidadeArg = capacidadeArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Sala");
		try {
			salas = sa.findAll();
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
				"Gravado com Sucesso! ", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			salas = sa.findByCapacidade(Integer.parseInt(capacidadeArg));
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

	public String getBooleanString(boolean s) {
		return s ? "Sim" : "Não";
	}

	public String getStatusString(int s) {
		String result;

		switch(s){
		case 1:
			result = "Ativo";
			break;
		case 2:
			result = "Em Manutenção";
			break;
		case 3:
			result = "Desativado";
			break;
		default:
			result = "";
			break;
		}

		return result;
	}
}