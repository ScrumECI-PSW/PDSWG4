/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.dao;

import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
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

    public LinkedList Reportados(Laboratorio lab);
    public LinkedList EquiposPorLaboratorio(String n);
}
