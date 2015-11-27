/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.dao;

import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import java.util.LinkedList;



/**
 *
 * @author 2101240
 */
public interface DaoLaboratorio {
    public void save(Laboratorio p) ;
    public Laboratorio load(int num);
    public void update (Laboratorio p);
    public void delete(Laboratorio p); 
     public LinkedList<ReporteProblema> load();

    public LinkedList<Laboratorio> EquiposReportados();
    public LinkedList<Laboratorio> getLaboratoriosProblemas();
}
