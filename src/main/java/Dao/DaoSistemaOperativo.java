/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Logica.SistemaOperativo;

/**
 *
 * @author 2101240
 */
public interface DaoSistemaOperativo {
    public void save(SistemaOperativo p) ;
    public SistemaOperativo load(int num);
    public void update (SistemaOperativo p);
    public void delete(SistemaOperativo p); 
    
}
