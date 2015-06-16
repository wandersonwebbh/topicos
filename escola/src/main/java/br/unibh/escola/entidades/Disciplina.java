package br.unibh.escola.entidades;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_DISCIPLINA")
@NamedQueries({ @NamedQuery(name="Disciplina.findByNomeECurso", query =
"select d from Disciplina d where d.nome like :nome and d.curso like :curso") })
public class Disciplina {

	public Disciplina() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@NotBlank
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "curso", length = 100, nullable = false)
	private String curso;

	@NotNull
	@Max(160)
	private Long cargaHoraria;

	@NotNull
	@Column(name = "tipo")
	private int tipo;

	@NotBlank
	@Size(min = 5, max = 4000)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "ementa", length = 4000, nullable = false)
	private String ementa;

	@NotBlank
	@Size(min = 5, max = 4000)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "bibliografia", length = 4000, nullable = false)
	private String bibliografia;

	@NotBlank
	@Size(min = 5, max = 4000)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "distribuicaoAvaliacao", length = 4000, nullable = false)
	private String distribuicaoAvaliacao;

	@NotBlank
	@Size(min = 5, max = 4000)
	@Column(name = "observacao", length = 4000, nullable = false)
	private String observacao;

	@NotNull
	@ManyToOne
	private Sala sala;

	@NotNull
	@ManyToOne
	private Professor professor;

	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TB_ALUNO_DISCIPLINA", joinColumns = @JoinColumn(name = "ID_DISCIPLINA", nullable = false, 
	updatable = false), inverseJoinColumns = @JoinColumn(name = "ID_ALUNO", nullable = false, updatable = false ))
	private List<Aluno> alunos;

	@Version
	private int versao;

	

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



	public String getCurso() {
		return curso;
	}



	public void setCurso(String curso) {
		this.curso = curso;
	}



	public Long getCargaHoraria() {
		return cargaHoraria;
	}



	public void setCargaHoraria(Long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public String getEmenta() {
		return ementa;
	}



	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}



	public String getBibliografia() {
		return bibliografia;
	}



	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}



	public String getDistribuicaoAvaliacao() {
		return distribuicaoAvaliacao;
	}



	public void setDistribuicaoAvaliacao(String distribuicaoAvaliacao) {
		this.distribuicaoAvaliacao = distribuicaoAvaliacao;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public Sala getSala() {
		return sala;
	}



	public void setSala(Sala sala) {
		this.sala = sala;
	}



	public Professor getProfessor() {
		return professor;
	}



	public void setProfessor(Professor professor) {
		this.professor = professor;
	}



	public List<Aluno> getAlunos() {
		return alunos;
	}



	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}



	public int getVersao() {
		return versao;
	}



	public void setVersao(int versao) {
		this.versao = versao;
	}



	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", curso=" + curso
				+ ", cargaHoraria=" + cargaHoraria + ", tipo=" + tipo
				+ ", ementa=" + ementa + ", bibliografia=" + bibliografia
				+ ", distribuicaoAvaliacao=" + distribuicaoAvaliacao
				+ ", observacao=" + observacao 
				+ ", versao=" + versao + "]";
	}

}