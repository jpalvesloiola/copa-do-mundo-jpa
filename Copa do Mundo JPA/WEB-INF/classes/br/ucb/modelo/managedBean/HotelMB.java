package br.ucb.modelo.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.modelo.Hotel;
import br.ucb.modelo.dao.HotelDAO;

@ManagedBean
@SessionScoped
public class HotelMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Hotel hotel;
	private List<Hotel> hoteis;
	private HotelDAO hotelDAO;
	
	public HotelMB() {
		this.hotelDAO = new HotelDAO();
	}
	
	public String listar() {
		this.hoteis = this.hotelDAO.listar();
		return "hotelList";
	}
	
	public String incluir() {
		this.hotel = new Hotel();
		return "hotelForm";
	}
	
	public String selecionarAlteracao(Hotel hotel) {
		this.hotel = hotel;
		return "hotelForm";
	}
	
	public void excluir(Hotel hotel) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm=null;
		if (this.hotelDAO.excluir(hotel) > 0)
			fm = new FacesMessage("Excluído com sucesso!");
		else
			fm = new FacesMessage("Erro de exclusão!");
		fc.addMessage(null, fm);
		this.listar();
	}
	
	public String salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm=null;
		if (this.hotel.getId() == 0) { // Se id==0 é porque nunca esteve no banco
			if (this.hotelDAO.incluir(this.hotel) > 0)
				fm = new FacesMessage("Incluido com sucesso!");
			else
				fm = new FacesMessage("Erro de inclusão!");
		}
		else { // Alteracao
			if (this.hotelDAO.alterar(this.hotel) > 0)
				fm = new FacesMessage("Alterado com sucesso!");
			else
				fm = new FacesMessage("Erro de alteração!");
		}
		fc.addMessage(null, fm);
		return this.listar();
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

}
