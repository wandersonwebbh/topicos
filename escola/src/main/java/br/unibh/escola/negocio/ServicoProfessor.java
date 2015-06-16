package br.unibh.escola.negocio;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;

@Stateless
@LocalBean
public class ServicoProfessor implements DAO<Professor, Long> {
	@Inject
	EntityManager em;
	@Inject
	private Logger log;

	@Override
	public Professor insert(Professor t) throws Exception {
		log.info("Persistindo " + t);
		em.persist(t);
		return t;
	}

	@Override
	public Professor update(Professor t) throws Exception {
		log.info("Atualizando " + t);
		return em.merge(t);
	}

	@Override
	public void delete(Professor t) throws Exception {
		log.info("Removendo " + t);
		Object c = em.merge(t);
		em.remove(c);
	}

	@Override
	public Professor find(Long k) throws Exception {
		log.info("Encontrando Professor " + k);
		return em.find(Professor.class, k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> findAll() throws Exception {
		log.info("Encontrando todos os Professors");
		return em.createQuery("from Professor").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> findByName(String name) throws Exception {
		log.info("Encontrando Professors " + name);
		return em.createNamedQuery("Professor.findByName")
				.setParameter("nome", name + "%").getResultList();
	}
	
	@Override
	public List<Professor> findByCapacidade(int capacidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disciplina> findByNomeECurso(String nome, String curso) {
		// TODO Auto-generated method stub
		return null;
	}
}
