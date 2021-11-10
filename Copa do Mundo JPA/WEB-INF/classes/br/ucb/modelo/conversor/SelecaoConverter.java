package br.ucb.modelo.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.modelo.Selecao;
import br.ucb.modelo.dao.SelecaoDAO;

@FacesConverter(value="selecaoConverter")
public class SelecaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idSelecao) {
		return (new SelecaoDAO()).consultar(Long.parseLong(idSelecao));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object selecao) {
		return String.valueOf(((Selecao) selecao).getId());
	}

}
