package br.ucb.modelo.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.modelo.Jogador;
import br.ucb.modelo.Selecao;
import br.ucb.modelo.dao.JogadorDAO;
import br.ucb.modelo.dao.SelecaoDAO;
import br.ucb.modelo.enumerador.Posicao;

@ManagedBean
@SessionScoped
public class JogadorMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Jogador jogador;
	private List<Jogador> jogadores;
	private List<Selecao> selecoes;
	private JogadorDAO jogadorDAO;
	private SelecaoDAO selecaoDAO;
	private String filtroNomeJogador;
	
	public JogadorMB() {
		this.jogadorDAO = new JogadorDAO();
		this.selecaoDAO = new SelecaoDAO();
	}
	
	public String listar() {
		this.jogadores = this.jogadorDAO.listar();
		return "jogadorList";
	}
	
	public void filtrar() {
		this.jogadores = this.jogadorDAO.listar(this.filtroNomeJogador);
	}
	
	public String incluir() {
		this.jogador = new Jogador();
		this.selecoes = this.selecaoDAO.listar();
		return "jogadorForm";
	}
	
	public String selecionarAlteracao(Jogador jogador) {
		this.jogador = jogador;
		this.selecoes = this.selecaoDAO.listar();
		return "jogadorForm";
	}
	
	public void excluir(Jogador jogador) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm=null;
		if (this.jogadorDAO.excluir(jogador) > 0)
			fm = new FacesMessage("Excluído com sucesso!");
		else
			fm = new FacesMessage("Erro de exclusão!");
		fc.addMessage(null, fm);
		this.listar();
	}
	
	public String salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm=null;
		if (this.jogador.getId() == 0) { // Se id==0 é porque nunca esteve no banco
			if (this.jogadorDAO.incluir(this.jogador) > 0)
				fm = new FacesMessage("Incluido com sucesso!");
			else
				fm = new FacesMessage("Erro de inclusão!");
		}
		else { // Alteracao
			if (this.jogadorDAO.alterar(this.jogador) > 0)
				fm = new FacesMessage("Alterado com sucesso!");
			else
				fm = new FacesMessage("Erro de alteração!");
		}
		fc.addMessage(null, fm);
		return this.listar();
	}
	
	public List<Posicao> getPosicoes() {
		return new ArrayList<Posicao>(Arrays.asList(Posicao.values()));
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String getFiltroNomeJogador() {
		return filtroNomeJogador;
	}

	public void setFiltroNomeJogador(String filtroNomeJogador) {
		this.filtroNomeJogador = filtroNomeJogador;
	}

}
