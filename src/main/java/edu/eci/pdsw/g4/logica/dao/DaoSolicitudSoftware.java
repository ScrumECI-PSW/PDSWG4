/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.dao;


import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.logica.estructura.SolicitudSoftware;
import java.util.LinkedList;

/**
 *
 * @author 2101240
 */
public interface DaoSolicitudSoftware {
    public void save(SolicitudSoftware p) ;
    public SolicitudSoftware load(int num);
    public void update (SolicitudSoftware p);
    public void delete(SolicitudSoftware p); 
    public LinkedList<SolicitudSoftware> load();
    public LinkedList<SolicitudSoftware> load(boolean estado);
}
