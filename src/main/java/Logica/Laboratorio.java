/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author 2101240
 */
public class Laboratorio {
    
    private String nombre;
    private String Descripcion;
    private ArrayList<Equipo> Equipos;

    public Laboratorio(String nombre, String Descripcion, ArrayList Equipos) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.Equipos = Equipos;
    }

    public Laboratorio() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public ArrayList getEquipos() {
        return Equipos;
    }

    public void setEquipos(ArrayList Equipos) {
        this.Equipos = Equipos;
    }
    
}
