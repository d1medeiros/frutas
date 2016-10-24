package br.com.auron.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.auron.modelo.Produto;

@Stateless
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Produto produto){
		em.persist(produto);
	}

	public List<Produto> listaTodos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public void remover(Produto produto) {
		em.remove(em.merge(produto));
	}
	
}
