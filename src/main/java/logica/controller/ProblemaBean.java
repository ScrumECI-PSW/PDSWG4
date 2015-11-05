/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controller;

import Logica.Equipo;
import Logica.Facade.Facade;
import Logica.Laboratorio;
import Logica.ReporteProblema;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author 2099340
 */
@ManagedBean     
public class ProblemaBean {
    
    private final  Facade f=Facade.getInstance("applicationconfig.properties");
    private Date fecha;
    private String DescripcionProblema=null;
    private String Laboratorio="";
    private Equipo Equipo=null;
    private Date DailyTime;
    
    

    public ProblemaBean() {
       
        
        
    }
    

    public String getDescripcionProblema() {
        return DescripcionProblema;
    }

    public void setDescripcionProblema(String DescripcionProblema) {
        this.DescripcionProblema = DescripcionProblema;
    }

    public String getLaboratorio() {
        return Laboratorio;
    }

    public void setLaboratorio(String Laboratorio) {
        this.Laboratorio = Laboratorio;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }
    
    public ReporteProblema InsertProblema(){
        ReporteProblema problema;
        fecha = new Date();
        problema = new ReporteProblema(Equipo,DescripcionProblema,false,fecha.getDay(),fecha.getMonth(),fecha.getYear());
        f.registrarReporte(problema);
        return problema;
    }
    
    public List<Laboratorio> getLaboratorios(){
        return f.consultarLaboratorios();
    }
    
    public List<Equipo> getEquiposPorLaboratorio(){
        System.out.println(Laboratorio);
        return f.consultarEquiposPorLaboratorio(Laboratorio);
        
    }
    
}
