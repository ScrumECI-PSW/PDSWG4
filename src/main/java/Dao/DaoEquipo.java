/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Logica.Equipo;
import Logica.ReporteProblema;
import java.util.LinkedList;

/**
 *
 * @author 2101240
 */
public interface DaoEquipo {
    public void save(Equipo p) ;
    public Equipo load(int num);
    public void update (Equipo p);
    public void delete(Equipo p); 
    public LinkedList<ReporteProblema> load();
}
