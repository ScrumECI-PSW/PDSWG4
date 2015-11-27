/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.estructura;

/**
 *
 * @author 2100772
 */
public class Monitor {
    private int carnet;
    private String nombre;
    private int semestre;

    public Monitor(int carnet, String nombre, int semestre) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.semestre = semestre;
    }
           
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
}
