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
import javax.annotation.ManagedBean;
/**
 *
 * @author 2099340
 */
@ManagedBean 
    
public class ProblemaBean {
    
    private final  Facade f=Facade.getInstance("h2-applicationconfig.properties");
    private Date fecha;
    private String DescripcionProblema=null;
    private String Laboratorio=null;
    private int Equipo=0;
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

    public int getEquipo() {
        return Equipo;
    }

    public void setEquipo(int Equipo) {
        this.Equipo = Equipo;
    }
    
    public ReporteProblema InsertProblema(){
        ReporteProblema problema;
        fecha = new Date();
        problema = new ReporteProblema(new Equipo(Equipo,DescripcionProblema,false,new Laboratorio(Laboratorio,"",null)),DescripcionProblema,false,fecha.getDay(),fecha.getMonth(),fecha.getYear());
        f.registrarReporte(problema);
        return problema;
    }
    
}
