/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.estructura;

/**
 *
 * @author 2101240
 */
public class SistemaOperativo {

    
    private int id;
    private String nombre;
    private String version;
    
    public SistemaOperativo(int id, String nombre, String version) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
    }

    public SistemaOperativo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    
    
}
