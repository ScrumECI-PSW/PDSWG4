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
import Logica.SolicitudSoftware;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.SortedMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;


@ManagedBean
@SessionScoped
public class ProblemaBean {

    private final Facade f = Facade.getInstance("applicationconfig.properties");
    private Date fecha;
    private String problema = null;
    private String Laboratorio = "";
    private Equipo Equipo = null;
    private Date DailyTime;
    private LinkedList<Equipo> EquiposPorLaboratorio;
    private LinkedList<ReporteProblema> problemas;
    private LinkedList<SolicitudSoftware> solicitudes;
    ReporteProblema Prob=null;
    
    public ProblemaBean() {

    }
    
    public ReporteProblema getProb() {
        return Prob;
    }

    public void setProb(ReporteProblema Prob) {
        this.Prob = Prob;
    }
    
    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        System.out.println(problema + "set");
        this.problema = problema;
        insertProblema();
    }

    public void setEquiposPorLaboratorio(LinkedList<Equipo> EquiposPorLaboratorio) {
        this.EquiposPorLaboratorio = EquiposPorLaboratorio;
    }

    public LinkedList<Equipo> getEquiposPorLaboratorio() {
        return f.consultarEquiposPorLaboratorio(Laboratorio);

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
    /*
    @return: Lista ordenada por fecha con todos los problemas reportados 
    */
    public LinkedList<ReporteProblema>  getProblemasConPrioridad() {
        return f.problemasConMasTiempoSinResolver();
    }
    
    public void problemasSinSolucionar() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("PrioridadDeProblemas.xhtml",options,null);
    }

    public void setProblemas(LinkedList<ReporteProblema> problemas) {
        this.problemas = problemas;
    }
    
    public void solicitudesPendientes() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("solicitudesSoftware.xhtml",options,null);
    }
    
    public LinkedList<SolicitudSoftware> getSolicitudes() {
        return f.consultarSolicitudesSoftwareSinInstalar();
    }

    public void setSolicitudes(LinkedList<SolicitudSoftware> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void insertProblema() {
        fecha = new Date();
        this.Equipo.setEstado(true);
        this.Prob = new ReporteProblema(Equipo, this.problema, true, fecha.getDay(), fecha.getMonth(), fecha.getYear());
        f.registrarReporte(this.Prob);
       
    }
    
    public List<Laboratorio> getLaboratorios() {
        return f.consultarLaboratorios();
    }

}
