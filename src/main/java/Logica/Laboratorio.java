/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author 2101240
 */
public class Laboratorio {
    
    private String nombre;
    private String Descripcion;

    public Laboratorio(String nombre, String Descripcion) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
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
    
    public String toString(){
        return this.nombre;
    }
}
