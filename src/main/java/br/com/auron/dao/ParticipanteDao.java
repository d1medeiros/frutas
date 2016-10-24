package br.com.auron.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.auron.modelo.Participante;

@Stateless
public class ParticipanteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Participante participante){
		em.persist(participante);
	}

	public List<Participante> listaTodos() {
		return em.createQuery("from Participante", Participante.class).getResultList();
	}

	public void remover(Participante participante) {
		em.remove(em.merge(participante));
	}
}
