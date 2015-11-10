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
import java.util.SortedMap;
import java.util.TreeMap;

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
    
    /*
    @param: pr es el reporte de un problema que se va a registrar en la base de datos
    */
    public void registrarReporte(ReporteProblema pr){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        daof.getDaoReporteProblema().save(pr);
        daof.getDaoEquipo().update(pr.getEquipo());
        daof.commitTransaction();
        daof.endSession();
    }
    
    /*
    @return: Una lista con todos los problemas reportados y sus respectivos detalles
    */
    public LinkedList<ReporteProblema> consultarProblemas(){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList<ReporteProblema> drp=daof.getDaoReporteProblema().load();
        return drp;
    }
    
    /*
    @return: Lista de problemas ordenados por prioridad de fecha en la que se reportaron
    */
    public LinkedList<ReporteProblema> problemasConMasTiempoSinResolver(){
        LinkedList<ReporteProblema> consulta=new LinkedList();
        consulta=this.consultarProblemas();
        java.util.Date fechaSistema=new java.util.Date();  //Fecha del sistema
        SortedMap<Integer,ReporteProblema> diccionario=new TreeMap();
        LinkedList<ReporteProblema> tempo=new LinkedList();
                
        for(int i=0; i<consulta.size(); i++){
            if(consulta.get(i).getEstado()){
                double dias = Math.floor((fechaSistema.getTime()-consulta.get(i).getFecha().getTime()) / (1000 * 60 * 60 * 24));
                diccionario.put((int)dias, consulta.get(i));
            }
        }
        
        for (ReporteProblema reporte : diccionario.values()){
            tempo.add(reporte);
        }
        
        LinkedList<ReporteProblema> ordenadas= new LinkedList();          
        for (int i = tempo.size()-1; i >=0; i--) {
            ordenadas.add(tempo.get(i));
         }
        
        return ordenadas;
    }
    
    /*
    @param: Lista con todas las solicitudes de software con sus respectivas descripciones
    */
    public LinkedList<SolicitudSoftware> consultarSolicitudesSoftware(){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList<SolicitudSoftware> ss=daof.getDaoSolicitudSoftware().load();
        return ss;
    }
    
    /*
    @param: Lista con todas las solicitudes de software que tengan el estado activo (true), lo cual significa que son solicitudes sin instalar
    */
    public LinkedList<SolicitudSoftware> consultarSolicitudesSoftwareSinInstalar(){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList<SolicitudSoftware> ss=daof.getDaoSolicitudSoftware().load(true);
        return ss;
    }
    
    /*
    @param: El laboratorio que se desea registar en la base de datos
    */
    public void registrarLaboratorio(Laboratorio lb) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        daof.getDaoLaboratorio().save(lb);
        daof.commitTransaction();
        daof.endSession();
    }
    
    /*
    @param: El equipo que se desea registar en la base de datos
    */
    public void registrarEquipo(Equipo eq) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        daof.getDaoEquipo().save(eq);
        daof.commitTransaction();
        daof.endSession();
    }
    
    /*
    @return: Lista con los laboratorios que tienen equipos con reporte de problemas
    */
    public LinkedList consultarLaboratoriosConEquipoReporteProblemas() {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        return daof.getDaoLaboratorio().EquiposReportados(); 
    }
    /*
    @param: lab=Laboratorio del cual se quieren conocer los equipos con problemas
    @return: Lista con los equipos que tienen problema en el laboratorio ingresado
    */
    public LinkedList consultarEquiposProblemasLab(Laboratorio lab) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        return daof.getDaoEquipo().Reportados(lab); 
    }
    
    /*
    @param: eqq= Equipo del cual se quiere consultar sus reportes
    @return: Lista con todos los reportes de problema que tiene el equipo ingresado
    */
    public LinkedList consultarReporteProblemasEquipos(Equipo eqq) {
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        return daof.getDaoReporteProblema().Reportes(eqq); 
    }
    
    /*
    @return: Lista con todos los laboratorios
    */
    public LinkedList consultarLaboratorios(){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList list = daof.getDaoLaboratorio().getLaboratoriosProblemas();
        
        return list;
    }
    
    /*
    @param:n= ID del laboratorio sobre el cual se quiere consultar
    @return: Lista de todos los equipos que tiene el laboratorio de ID n
    */
    public LinkedList<Equipo> consultarEquiposPorLaboratorio(String n){
        DaoFactory daof=DaoFactory.getInstance(properties);
        daof.beginSession();
        LinkedList list = daof.getDaoEquipo().EquiposPorLaboratorio(n); 
        return list;
    }

}

