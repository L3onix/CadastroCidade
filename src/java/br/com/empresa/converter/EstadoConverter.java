/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.converter;

import br.com.empresa.dao.EstadoDAO;
import br.com.empresa.entidade.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author leonix
 */
@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String nome) {
        EstadoDAO dao = new EstadoDAO();
        return dao.pesquisaPorNome(nome);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object estado) {
        return ((Estado) estado).getNome();
    }

}
