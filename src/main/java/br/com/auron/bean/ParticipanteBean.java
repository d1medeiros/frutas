package br.com.auron.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.auron.dao.ParticipanteDao;
import br.com.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {
	
	private Participante participante = new Participante();
	@Inject
	private ParticipanteDao participanteDao;
	
	public Participante getParticipante() {
		return participante;
	}

	public List<Participante> getParticipantes() {
		return this.participanteDao.listaTodos();
	}
	
	public void cadastrar(){
		System.out.println("Cadastrando " + participante.getNome());
		this.participanteDao.inserir(participante);
		participante = new Participante();
	}

	public void remover(Participante participante){
		System.out.println("Removendo" + participante.getNome());
		this.participanteDao.remover(participante);
	}

}
