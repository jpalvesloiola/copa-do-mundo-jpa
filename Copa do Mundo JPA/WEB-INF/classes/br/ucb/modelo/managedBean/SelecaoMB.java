package br.ucb.modelo.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.modelo.Hotel;
import br.ucb.modelo.Selecao;
import br.ucb.modelo.dao.HotelDAO;
import br.ucb.modelo.dao.SelecaoDAO;

@ManagedBean
@SessionScoped
public class SelecaoMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Selecao selecao;
	private List<Selecao> selecoes;
	private SelecaoDAO selecaoDAO;
	private List<Hotel> hoteis;
	private HotelDAO hotelDAO;
	
	public SelecaoMB() {
		this.selecaoDAO = new SelecaoDAO();
		this.hotelDAO = new HotelDAO();
	}
	
	public String listar() {
		this.selecoes = this.selecaoDAO.listar();
		return "selecaoList";
	}
	
	public String incluir() {
		this.selecao = new Selecao();
		this.hoteis = this.hotelDAO.listar();
		return "selecaoForm";
	}
	
	public String selecionarAlteracao(Selecao selecao) {
		this.selecao = selecao;
		this.hoteis = this.hotelDAO.listar();
		return "selecaoForm";
	}
	
	public void excluir(Selecao selecao) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm=null;
		if (this.selecaoDAO.excluir(selecao) > 0)
			fm = new FacesMessage("Excluído com sucesso!");
		else
			fm = new FacesMessage("Erro de exclusão!");
		fc.addMessage(null, fm);
		this.listar();
	}
	
	public String salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm=null;
		if (this.selecao.getId() == 0) { // Se id==0 é porque nunca esteve no banco
			if (this.selecaoDAO.incluir(this.selecao) > 0)
				fm = new FacesMessage("Incluido com sucesso!");
			else
				fm = new FacesMessage("Erro de inclusão!");
		}
		else { // Alteracao
			if (this.selecaoDAO.alterar(this.selecao) > 0)
				fm = new FacesMessage("Alterado com sucesso!");
			else
				fm = new FacesMessage("Erro de alteração!");
		}
		fc.addMessage(null, fm);
		return this.listar();
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

}
