/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author 2100772
 */
public class SoporteAcademico {
    private int id;
    private int monitor_id;
    private boolean solucionado;
    private String lenguaje;
    private Date fecha;
    private String tema;
    private String comentario;

    public SoporteAcademico(int monitor_id, boolean solucionado, String lenguaje, Date fecha, String tema, String comentario) {
        this.monitor_id = monitor_id;
        this.solucionado = solucionado;
        this.lenguaje = lenguaje;
        this.fecha = fecha;
        this.tema = tema;
        this.comentario = comentario;
        this.id = 0;
    }
    
    public SoporteAcademico(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(int monitor_id) {
        this.monitor_id = monitor_id;
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
