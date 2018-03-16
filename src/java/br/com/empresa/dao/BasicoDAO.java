/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.empresa.dao;

import java.util.List;

/**
 *
 * @author leonix
 */
public interface BasicoDAO {
    public void salvar(Object item);
    public List<Object> listar();
    public void alterar(Object item);
    public void deletar(Integer id);
    public Object pesquisarId(Integer id);
}
