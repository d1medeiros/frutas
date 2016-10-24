package br.com.auron.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.auron.modelo.Fornecedor;

@Stateless
public class FornecedorDao {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Fornecedor fornecedor){
		em.persist(fornecedor);
	}

	public List<Fornecedor> listaTodos() {
		return em.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}

	public void remover(Fornecedor fornecedor) {
		em.remove(em.merge(fornecedor));
	}

	public Fornecedor fornecedorPorId(Integer fornecedorId) {
		return this.em.find(Fornecedor.class, fornecedorId);
	}
	
}
