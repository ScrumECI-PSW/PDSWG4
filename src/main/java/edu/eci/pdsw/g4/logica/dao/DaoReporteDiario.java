/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.dao;

import edu.eci.pdsw.g4.logica.estructura.ReporteDiario;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import java.util.LinkedList;

/**
 *
 * @author 2099340
 */
public interface DaoReporteDiario {
    
    public void insertarDiario(ReporteDiario lb);
    public LinkedList<ReporteDiario> consultar(ReporteProblema rp);
    public void insertarDairioxProblema(ReporteDiario lb);
}
