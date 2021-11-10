package br.ucb.modelo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.ucb.modelo.Jogador;

public class JogadorDAO extends GenericDAO<Jogador> implements Serializable {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Jogador> listar(String filtroNome) {
		Query q = super.getEm().createQuery("SELECT j FROM Jogador j WHERE j.nome LIKE :filtroNome");
		q.setParameter("filtroNome", "%"+filtroNome+"%");
		return q.getResultList();
	}
	
	public int excluir(Jogador jogador) {
		jogador.getSelecao().getJogadores().remove(jogador);
		return super.excluir(jogador);
	}
	

}





