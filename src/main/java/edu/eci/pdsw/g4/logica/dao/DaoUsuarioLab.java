/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.dao;


import edu.eci.pdsw.g4.logica.estructura.UsuarioLab;
import java.util.LinkedList;


/**
 *
 * @author 2100772
 */
public interface DaoUsuarioLab {
    public void save(UsuarioLab u) ;
    public UsuarioLab load(int num);
    public void update (UsuarioLab u);
    public void delete(UsuarioLab u);
    public LinkedList<UsuarioLab> load();
}
