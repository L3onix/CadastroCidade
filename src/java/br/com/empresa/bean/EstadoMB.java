/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.EstadoDAO;
import br.com.empresa.entidade.Estado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author leonix
 */
@ManagedBean
@ViewScoped
public class EstadoMB {
    
    private Estado estado;
    private List<Estado> lista;
    private EstadoDAO dao;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getLista() {
        return lista;
    }

    public void setLista(List<Estado> lista) {
        this.lista = lista;
    }

    public EstadoDAO getDao() {
        return dao;
    }

    public void setDao(EstadoDAO dao) {
        this.dao = dao;
    }
    
    @PostConstruct
    public void inicializarTela(){
        dao = new EstadoDAO();
        lista = dao.listar();
        
        limpar();
    }
    
    public void limpar(){
        estado = new Estado();
    }
    
    public void salvar(){
        //TODO: Fazer validações referentes às regras de negócio
        
        dao = new EstadoDAO();
        dao.salvar(estado);
        
        inicializarTela();
    }
}
