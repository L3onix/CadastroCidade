/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import br.com.empresa.entidade.Cidade;
import br.com.empresa.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leonix
 */
public class CidadeDAO implements BasicoDAO{
    @Override
    public List<Object> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Object> cidades = sessao.getNamedQuery("Cidade.findAll").list();
        
        sessao.close();
        return cidades;
    }
    
    public Cidade pesquisarId(Integer id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Cidade cidade = (Cidade) sessao.merge(sessao.get(Cidade.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
        
        return cidade;
    }

    @Override
    public void salvar(Object item) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.persist(item);
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void alterar(Object item) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.merge(item);
        
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void deletar(Integer id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.delete(sessao.get(Cidade.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    }
}