/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author 2101240
 */
public class ReporteProblema {
    
    private int id;
    private Equipo equipo;
    private String descripcion;
    private boolean estado;
    private Date fecha;

    public ReporteProblema(int id, Equipo equipo, String descripcion, boolean estado, Date fecha) {
        this.id = id;
        this.equipo = equipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
    }

    public ReporteProblema() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    
}