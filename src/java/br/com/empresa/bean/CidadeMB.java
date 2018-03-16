/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.bean;

import br.com.empresa.dao.CidadeDAO;
import br.com.empresa.entidade.Cidade;
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
public class CidadeMB {
    
    private Cidade cidade;
    private List<Object> lista;
    private CidadeDAO dao;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void inicializarTela(){
        dao = new CidadeDAO();
        lista = dao.listar();
        
        limpar();
    }
    
    public void limpar(){
        cidade = new Cidade();
    }
    
    public void salvar(){
        
        dao = new CidadeDAO();
        if(cidade.getId() == null){
            dao.salvar(cidade);
        }else{
            dao.alterar(cidade);
        }
        
        inicializarTela();
    }
    
    public void deletar(Cidade item){
        dao = new CidadeDAO();
        dao.deletar(item.getId());
        inicializarTela();
    }
    
    public void carregarCidade(Cidade item){
        cidade = item;
    }
}
