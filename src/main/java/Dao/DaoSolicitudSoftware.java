/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Logica.ReporteProblema;
import Logica.SolicitudSoftware;
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
    public LinkedList<ReporteProblema> load();
}
