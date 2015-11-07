/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author 2101240
 */
public class Equipo {
    
    private int id;
    private String descripcion;
    private boolean estado;
    private Laboratorio laboratorio;
   


    public Equipo(int id, String descripcion, boolean estado, Laboratorio laboratorio_ID) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.laboratorio = laboratorio_ID;
    }

    public Equipo() {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio_ID) {
        this.laboratorio = laboratorio_ID;
    }
    
    public String toString(){
        return Integer.toString(id);
    }
    
}
