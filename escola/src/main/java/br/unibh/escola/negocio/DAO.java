package br.unibh.escola.negocio;

import java.util.List;

import br.unibh.escola.entidades.Disciplina;

public interface DAO<T, K> {
	public T insert(T t) throws Exception;

	public T update(T t) throws Exception;

	public void delete(T t) throws Exception;

	public T find(K k) throws Exception;

	public List<T> findAll() throws Exception;

	public List<T> findByName(String name) throws Exception;
	
	public List<T> findByCapacidade(int capacidade) throws Exception;
	
	public List<Disciplina> findByNomeECurso(String nome, String curso);
}
