/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Facade;

import Dao.DaoFactory;
import Dao.DaoReporteProblema;
import Logica.Equipo;
import Logica.Laboratorio;
import Logica.ReporteProblema;
import Logica.SolicitudSoftware;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author 2099340
 */
public class Facade {
    
    
    private static Facade instance=null;
    
    private final Properties properties=new Properties();
    
    private Facade(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
    }
    
    public static Facade getInstance(String propertiesFileName) throws RuntimeException{
        if (instance==null){
            try {
                instance=new Facade(propertiesFileName);
            } catch (IOException ex) {
                throw new RuntimeException("Error on application configuration:",ex);
            }
        }        
        return instance;
    }
    
    public static Facade getInstance(){
        
        return instance;
    }
    
    public void registrarReporte(ReporteProblema pr){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        daof.getDaoReporteProblema().save(pr);
        daof.commitTransaction();
        daof.endSession();
    }
    
    public LinkedList<ReporteProblema> consultarProblemas(){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList<ReporteProblema> drp=daof.getDaoReporteProblema().load();
        return drp;
    }
    
    public LinkedList<SolicitudSoftware> consultarSolicitudesSoftware(){
        return null;
    }

    public void registrarLaboratorio(Laboratorio lb) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        daof.getDaoLaboratorio().save(lb);
        daof.commitTransaction();
        daof.endSession();
    }

    public void registrarEquipo(Equipo eq) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        daof.getDaoEquipo().save(eq);
        daof.commitTransaction();
        daof.endSession();
    }

    public LinkedList consultarLaboratoriosConEquipoReporteProblemas() {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        return daof.getDaoLaboratorio().EquiposReportados(); 
    }

    public LinkedList consultarEquiposProblemasLab(Laboratorio lab) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        return daof.getDaoEquipo().Reportados(lab); 
    }

    public LinkedList consultarReporteProblemasEquipos(Equipo eqq) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        return daof.getDaoReporteProblema().Reportes(eqq); 
    }
    
    public LinkedList consultarLaboratorios(){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList list = daof.getDaoLaboratorio().getLaboratoriosProblemas();
        
        return list;
    }
    
    public LinkedList<Equipo> consultarEquiposPorLaboratorio(String n){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList list = daof.getDaoEquipo().EquiposPorLaboratorio(n);   
        System.out.println(list.size());
        return list;
    }

   
}
