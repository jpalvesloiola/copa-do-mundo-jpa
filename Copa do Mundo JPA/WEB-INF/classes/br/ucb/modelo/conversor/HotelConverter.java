package br.ucb.modelo.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.modelo.Hotel;
import br.ucb.modelo.dao.HotelDAO;

@FacesConverter(value="hotelConverter")
public class HotelConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idHotel) {
		return (new HotelDAO()).consultar(Long.parseLong(idHotel));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object hotel) {
		return String.valueOf(((Hotel) hotel).getId());
	}

}
