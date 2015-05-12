package br.unibh.escola.negocio;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.escola.entidades.Sala;

@Stateless
@LocalBean
public class ServicoSala implements DAO<Sala, Long> {
	@Inject
	EntityManager em;
	@Inject
	private Logger log;

	@Override
	public Sala insert(Sala t) throws Exception {
		log.info("Persistindo " + t);
		em.persist(t);
		return t;
	}

	@Override
	public Sala update(Sala t) throws Exception {
		log.info("Atualizando " + t);
		return em.merge(t);
	}

	@Override
	public void delete(Sala t) throws Exception {
		log.info("Removendo " + t);
		Object c = em.merge(t);
		em.remove(c);
	}

	@Override
	public Sala find(Long k) throws Exception {
		log.info("Encontrando Sala " + k);
		return em.find(Sala.class, k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sala> findAll() throws Exception {
		log.info("Encontrando Sala");
		return em.createQuery("from Sala").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Sala> findBycapacidade(int capacidade) throws Exception {
		log.info("Encontrando Sala " + capacidade);
		return em.createNamedQuery("Sala.findBycapacidade")
				.setParameter("capacidade", capacidade).getResultList();
	}

	@Override
	public List<Sala> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sala> findBycapacidade(Integer capacidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}