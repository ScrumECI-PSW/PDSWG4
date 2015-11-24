/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author 2099340
 */
public class ReporteDiario {
    
    private String Descripcion = null;
    private int id = 0;
    private ReporteProblema reporteProblema=null;

    public ReporteProblema getReporteProblema() {
        return reporteProblema;
    }

    public void setReporteProblema(ReporteProblema reporteProblema) {
        this.reporteProblema = reporteProblema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public ReporteDiario() {
    }

   public ReporteDiario(String descripcion, ReporteProblema reporteProblema) {
   this.Descripcion=descripcion;
   this.reporteProblema=reporteProblema;
   }

    
    
   
}
