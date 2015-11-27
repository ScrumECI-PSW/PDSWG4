/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.estructura;

import java.sql.Date;

/**
 *
 * @author 2101240
 */
public class SolicitudSoftware {
    
    private int id;
    private String descripcion;
    private String enlaces;
    private boolean estado;
    private Date fecha;
    private String justificacion;

    public SolicitudSoftware(int id, String descripcion, String enlaces, boolean estado, Date fecha, String justificacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.enlaces = enlaces;
        this.estado = estado;
        this.fecha = fecha;
        this.justificacion = justificacion;
    }

    public SolicitudSoftware() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(String enlaces) {
        this.enlaces = enlaces;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    
}
