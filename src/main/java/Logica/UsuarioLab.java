/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author 2100772
 */
public class UsuarioLab {
    private int carnet;
    private String nombre;
    private int semestre;
    
    public UsuarioLab(int carnet, String nombre, int semestre) {
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
