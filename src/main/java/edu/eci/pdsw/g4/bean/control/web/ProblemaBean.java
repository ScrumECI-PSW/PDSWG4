/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.bean.control.web;

import edu.eci.pdsw.g4.bean.control.seguridad.ShiroLoginBean;
import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.facade.Facade;
import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import edu.eci.pdsw.g4.logica.estructura.ReporteDiario;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.logica.estructura.SolicitudSoftware;
import edu.eci.pdsw.g4.logica.estructura.SoporteAcademico;
import java.io.IOException;
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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    private String laboratorio = "";
    private Equipo equipo = null;
    private Date dailyTime;
    private LinkedList<Equipo> equiposPorLaboratorio;
    private LinkedList<ReporteProblema> problemas;
    private LinkedList<SolicitudSoftware> solicitudes;
    private boolean intento=true;
    private boolean intentoLab=true;
    private List<Laboratorio> lab; 
    private String lenguaje = "";
    private String tema = "";
    private LinkedList<Equipo> pv=null;
    private ReporteProblema prob=null;
    private boolean bandera = true;
    private boolean soporteSolucionado;
    private String comentariosSoporte="";
    private int idMonitor;
    
    
    
    /**
     * Retorna el id del monitor que brindo el Soporte Academico 
    @return idMonitor Carnet del monitor
    */
    public int getIdMonitor() {
        return idMonitor;
    }

    /**
     * Ingresa en carnet del Monitor que hace el Soporte Academico
     * @param idMonitor Carnet del monitor
     */
    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }
    
    /**
     * Retorna los comentarios hechos por el monitor en el Soporte Academico
     * @param comentariosSoporte Comentarios del Soporte Academico
     */
    public String getComentariosSoporte() {
        return comentariosSoporte;
    }
    
    /**
     * Ingresa los comentarios que el Monitor hace en cada Soporte Academico 
     * @param comentariosSoporte Comentarios de los Soportes Academicos
     */
    public void setComentariosSoporte(String comentariosSoporte) {
        this.comentariosSoporte = comentariosSoporte;
    }
    
    /**
     * Retorna el tema sobre el que se realizo el Soporte Academico
     * @param tema Tema del Soporte Academico 
     */
    public String getTema() {
        return tema;
    }
    
    /**
     * Ingresa el tema por sobre el que se realizo el Soporte Academico
     * @param tema Tema del Soporte Academico 
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    /**
     * Retorna true si esta solucionado o false si no esta solucionado el Soporte Academico
     * @return soporteSolucionado valor con el que se sabe si esta o no solucionado el Soporte Academico 
     */
    public boolean isSoporteSolucionado() {
        return soporteSolucionado;
    }
    
    /**
     * Ingresa si se pudo solucionar o no el Soporte Academico asignado
     * @param soporteSolucionado valor con el que se sabe si esta o no solucionado el Soporte Academico 
     */
    public void setSoporteSolucionado(boolean soporteSolucionado) {
        this.soporteSolucionado = soporteSolucionado;
    }
    /**
     * Retorna el lenguaje de programacion en el que se brindo el Soporte Academico
     * @return lenguaje Lenguaje de programacion 
     */
    public String getLenguaje() {
        return lenguaje;
    }
    /**
     * Ingresa el lenguaje de programacion en el que se brindo el Soporte Academico
     * @param lenguaje Lenguaje de programacion en el que se brindo el Soporte Academico
     */
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    /**
     * Devuelve descripcion del reporte diario de un cliente
     * @return Descripcion del reporte diario
     */
    public String getDescripcionReporteDiario() {
        return descripcionReporteDiario;
    }
    /**
     * Ingresa descripcion del reporte diario de un cliente
     * @param descripcionReporteDiario Descripcion reporte diario
     */
    public void setDescripcionReporteDiario(String descripcionReporteDiario) {
        if(this.bandera){
            this.descripcionReporteDiario = descripcionReporteDiario;
            ReportarUnDiario();
            this.bandera=false;
            this.descripcionReporteDiario = "";
        }
        
    }
    
    /**
     * Devuelve el estado de un reporte diario en un reporte de un problema de un computador
     * @return el estado de un reporte diario en reporte de un problema de un computador
     */
    public String getEstadoProblema() {
        return estadoProblema;
    }
    /**
     * Ingresa el estado de un reporte diario en un reporte de un problema de un computador,
     * actualizando el problema en dado caso si fue terminado
     * @param estadoProblema estado del reporte diario
     */
    public void setEstadoProblema(String estadoProblema) {
        this.estadoProblema = estadoProblema;
        if(this.estadoProblema.equals("Terminado") & this.prob!=null){
            f.actualizarEstadoProblema(prob);
            this.estadoProblema="selecccione estado";
        }
    }
    
    /**
     * 
     * @return 
     */
    public ReporteDiario getRepD() {
        return repD;
    }
    /**
     * 
     * @param repD 
     */
    public void setRepD(ReporteDiario repD) {
        this.repD = repD;
    }
    
    /**
     * retorna un Reporte de un Problema presentado en un computador
     * @return ReporteProblema seleccionado por el usuario
     */
    public ReporteProblema getProb() {
        return prob;
    }
    /**
     * Ingresa un Reporte de un Problema de un computador seleccionado por el cliente
     * @param Prob Reporte de un Problema de un computador 
     */
    public void setProb(ReporteProblema Prob) {
        this.bandera=true;
        this.prob = Prob;
    }
    
    /**
     * Devuelve la descripcion del reporte de problema de un computador
     * @return problema descripcion del reporte de problema de un computador
     */
    public String getProblema() {
        return problema;
    }
    
    /**
     * Ingresa la descripcion del reporte de problema de un computador
     * @param problema descripcion del reporte de problema de un computador
     */
    public void setProblema(String problema) {
        this.problema = problema;
        insertProblema();
    }
    /**
     * Ingresa la lista de computadores disponibles de un laboratorio de la decanatura de sistemas seleccionado
     * @param EquiposPorLaboratorio computadores de un laboratorio de la decanatura de sistema seleccionado
     */
    public void setEquiposPorLaboratorio(LinkedList<Equipo> EquiposPorLaboratorio) {
        this.equiposPorLaboratorio = EquiposPorLaboratorio;
    }
    /**
     * Devuelve la lista de computadores disponibles de un laboratorio de la decanatura de sistemas seleccionado
     * @return pv lista computadores disponibles de un laboratorio de la decanatura de sistemas seleccionado
     */
    public LinkedList<Equipo> getEquiposPorLaboratorio() {
        if(this.intento){
            this.pv=f.consultarEquiposPorLaboratorio(laboratorio);
            this.intento=false;
            this.intentoLab=true;
        }
        return this.pv;

    }

    /**
     * Devuelve el laboratorio que posee la decanatura de sistema seleccionada por un el cliente 
     * @return laboratorio Laboratorio decanatura de sistemas
     */
    public String getLaboratorio() {
        return laboratorio;
    }
    /**
    * Ingresa el laboratorio que posee la decanatura de sistema seleccionada por un el cliente 
    * @param Laboratorio Laboratorio decanatura de sistemas
    */
    public void setLaboratorio(String Laboratorio) {
        this.intento=true;
        this.laboratorio = Laboratorio;
    }
    /**
     * Devuelve un computador de un laboratorio de la decanatura de sistema seleccionado
     * @return equipo computador de un laboratorio de la decanatura de sistema seleccionado
     */
    public Equipo getEquipo() {
        return equipo;
    }
    /**
     * Ingresa un computador de un laboratorio de la decanatura de sistema seleccionado
     * @param Equipo Compuatdor de un laboratorio de la decanatura de sistema seleccionado
     */
    public void setEquipo(Equipo Equipo) {
        this.equipo = Equipo;
    }
    /*
    @return: Lista ordenada por fecha con todos los problemas reportados 
    */
    public LinkedList<ReporteProblema>  getProblemasConPrioridad() {
        return f.problemasConMasTiempoSinResolver();
    }
    /**
     * 
     */
    public void problemasSinSolucionar() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("PrioridadDeProblemas.xhtml",options,null);
    }
    /**
     * Ingresa la lista de los reportes de problema que tiene un laboratorio de la decanatura de sistema seleccionado
     * @param problemas 
     */
    public void setProblemas(LinkedList<ReporteProblema> problemas) {
        this.problemas = problemas;
    }
    /**
     * 
     */
    public void solicitudesPendientes() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("solicitudesSoftware.xhtml",options,null);
    }
    /**
     * 
     * @return 
     */
    public LinkedList<SolicitudSoftware> getSolicitudes() {
        return f.consultarSolicitudesSoftwareSinInstalar();
    }
    /**
     * 
     * @param solicitudes 
     */
    public void setSolicitudes(LinkedList<SolicitudSoftware> solicitudes) {
        this.solicitudes = solicitudes;
    }
    /**
     * Registra un reporte de problema de un equipo de un laboratorio de la decanatura de sistema seleccionado
     */
    public void insertProblema() {
        
        
        java.util.Date d = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(d.getTime());
        
        this.equipo.setEstado(true);
        this.prob = new ReporteProblema(equipo, this.problema, true,fecha);
        f.registrarReporte(this.prob);
       
    }
    /**
     * Devuelve una lista que contiene todos los laboratorios que posee la decanatura de sistemas
     * @return Laboratorios decanatura de sistemas
     */
    public List<Laboratorio> getLaboratorios() {
        if(this.intentoLab){
            this.lab=f.consultarLaboratorios();
            this.intentoLab=false;
        }
        return this.lab; 
    }
    /**
     * Registra un reporte diario que realizo un monitor
     */
    public void ReportarUnDiario(){
        f.registrarReporteDiario(new ReporteDiario(descripcionReporteDiario,prob));
    }
    /**
     * 
     */
    public void registarSoporte() throws IOException{
        java.util.Date d = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(d.getTime());
        f.registrarSoporte(new SoporteAcademico(this.getIdMonitor(),soporteSolucionado,lenguaje,fecha,tema,comentariosSoporte));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    } 
}
