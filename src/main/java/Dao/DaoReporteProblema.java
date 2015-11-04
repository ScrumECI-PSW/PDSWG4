/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Logica.ReporteProblema;
import java.util.LinkedList;

/**
 *
 * @author 2101240
 */
public interface DaoReporteProblema {
    
    public void save(ReporteProblema p) ;
    public ReporteProblema load(int num);
    public void update (ReporteProblema p);
    public void delete(ReporteProblema p); 

    public LinkedList<ReporteProblema> load();
    
}
