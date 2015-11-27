/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controller;

import Logica.Equipo;
import Logica.Facade.Facade;
import Logica.Laboratorio;
import Logica.ReporteDiario;
import Logica.ReporteProblema;
import Logica.SolicitudSoftware;
import Logica.SoporteAcademico;
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
import org.apache.shiro.authc.UsernamePasswordToken;
import org.primefaces.context.RequestContext;


@ManagedBean
@SessionScoped
public class ProblemaBean {

    
    private String descripcionReporteDiario="";    
    private String estadoProblema = "";
    private final Facade f = Facade.getInstance("applicationconfig.properties");
    private Date fecha;
    private ReporteDiario repD = null;
    private String problema = null;
    private String Laboratorio = "";
    private Equipo Equipo = null;
    private Date DailyTime;
    private LinkedList<Equipo> EquiposPorLaboratorio;
    private LinkedList<ReporteProblema> problemas;
    private LinkedList<SolicitudSoftware> solicitudes;
    private boolean intento=true;
    private boolean intentoLab=true;
    private List<Laboratorio> lab; 
    private String lenguaje = "";
    private String tema = "";
    private LinkedList<Equipo> pv=null;
    private ReporteProblema Prob=null;

    private boolean bandera = true;

    private boolean soporteSolucionado;
    private String comentariosSoporte;


    
    public ProblemaBean() {
     
    }
    
    public String getComentariosSoporte() {
        return comentariosSoporte;
    }

    public void setComentariosSoporte(String comentariosSoporte) {
        this.comentariosSoporte = comentariosSoporte;
    }
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
        //reportarSoporteAcademico(); falta registrar el SoporteAcademico
    }

    public boolean isSoporteSolucionado() {
        return soporteSolucionado;
    }

    public void setSoporteSolucionado(boolean soporteSolucionado) {
        this.soporteSolucionado = soporteSolucionado;
    }
    
    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    public String getDescripcionReporteDiario() {
        return descripcionReporteDiario;
    }

    public void setDescripcionReporteDiario(String descripcionReporteDiario) {
        if(this.bandera){
            System.out.println("ENTRA A ACTUALIZAR");
            this.descripcionReporteDiario = descripcionReporteDiario;
            ReportarUnDiario();
            this.bandera=false;
            this.descripcionReporteDiario = "";
        }
        
    }
    
    public String getEstadoProblema() {
        return estadoProblema;
    }

    public void setEstadoProblema(String estadoProblema) {
        System.out.println("ENTRA A ACTUALIZAR "+estadoProblema);
        this.estadoProblema = estadoProblema;
        if(this.estadoProblema.equals("Terminado") & this.Prob!=null){
            f.actualizarEstadoProblema(Prob);
            this.estadoProblema="selecccione estado";
        }
    }
    
    
    public ReporteDiario getRepD() {
        return repD;
    }

    public void setRepD(ReporteDiario repD) {
        this.repD = repD;
    }
    
    public ReporteProblema getProb() {
        return Prob;
    }

    public void setProb(ReporteProblema Prob) {
        this.bandera=true;
        this.Prob = Prob;
    }
    
    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
        insertProblema();
    }

    public void setEquiposPorLaboratorio(LinkedList<Equipo> EquiposPorLaboratorio) {
        this.EquiposPorLaboratorio = EquiposPorLaboratorio;
    }

    public LinkedList<Equipo> getEquiposPorLaboratorio() {
        if(this.intento){
            this.pv=f.consultarEquiposPorLaboratorio(Laboratorio);
            this.intento=false;
            this.intentoLab=true;
            System.out.println(this.pv.size());
        }
        return this.pv;

    }

    public String getLaboratorio() {
        return Laboratorio;
    }

    public void setLaboratorio(String Laboratorio) {
        this.intento=true;
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
        java.util.Date fecha=new java.util.Date();
        this.Equipo.setEstado(true);
        this.Prob = new ReporteProblema(Equipo, this.problema, true,fecha.getDay(), fecha.getMonth(), fecha.getYear());
        f.registrarReporte(this.Prob);
       
    }
    
    public List<Laboratorio> getLaboratorios() {
        System.out.println("Entro a laboratorios");
        if(this.intentoLab){
            this.lab=f.consultarLaboratorios();
            this.intentoLab=false;
        }
        return this.lab; 
    }
    
    public void ReportarUnDiario(){
        f.registrarReporteDiario(new ReporteDiario(descripcionReporteDiario,Prob));
    }
    
    public void registarSoporte(){
        System.out.println("llego a registrar soporte");
        UsernamePasswordToken monitor=new UsernamePasswordToken();
        java.util.Date d = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(d.getDate());
        f.registrarSoporte(new SoporteAcademico(2100772,soporteSolucionado,lenguaje,fecha,tema,comentariosSoporte));
    } 
}
