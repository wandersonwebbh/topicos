package br.unibh.escola.visao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;
import br.unibh.escola.negocio.ServicoAluno;
import br.unibh.escola.negocio.ServicoDisciplina;
import br.unibh.escola.negocio.ServicoProfessor;
import br.unibh.escola.negocio.ServicoSala;

@ManagedBean(name = "disciplinamb")
@ViewScoped
public class ControleDisciplina {
	@Inject
	private Logger log;
	@Inject
	private ServicoAluno sa;
	@Inject
	private ServicoDisciplina sd;
	@Inject
	private ServicoSala ss;
	@Inject
	private ServicoProfessor sp;

	private Disciplina disciplina;
	private String nomeArg;
	private String cursoArg;
	private Long id;
	private List<Disciplina> disciplinas;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public ServicoAluno getSa() {
		return sa;
	}

	public void setSa(ServicoAluno sa) {
		this.sa = sa;
	}

	public ServicoDisciplina getSd() {
		return sd;
	}

	public void setSd(ServicoDisciplina sd) {
		this.sd = sd;
	}

	public ServicoSala getSs() {
		return ss;
	}

	public void setSs(ServicoSala ss) {
		this.ss = ss;
	}

	public ServicoProfessor getSp() {
		return sp;
	}

	public void setSp(ServicoProfessor sp) {
		this.sp = sp;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public String getCursoArg() {
		return cursoArg;
	}

	public void setCursoArg(String cursoArg) {
		this.cursoArg = cursoArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Disciplina");
		try {
			disciplinas = sd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (disciplina.getId() == null) {
				disciplina = sd.insert(disciplina);
			} else {
				disciplina = sd.update(disciplina);
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
			disciplinas = sd.findByNomeECurso(nomeArg, cursoArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		disciplina = new Disciplina();
	}

	public void cancelar() {
		disciplina = null;
	}

	public void editar() {
		try {
			disciplina = sd.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public void excluir() {
		try {
			sd.delete(sd.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public String getTipoString(int t) {
		String result;

		switch (t) {
		case 1:
			result = "Presencial";
			break;
		case 2:
			result = "À distância";
			break;
		case 3:
			result = "Presencial e/ou Distância";
			break;
		default:
			result = "";
			break;
		}

		return result;
	}

	public List<Aluno> getAlunos() {
		try {
			return sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Aluno>();
	}

	public List<Sala> getSalas() {
		try {
			return ss.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Sala>();
	}

	public List<Professor> getProfessor() {
		try {
			return sp.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Professor>();
	}
}