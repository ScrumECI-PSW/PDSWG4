/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Facade;

import Dao.DaoFactory;
import Logica.ReporteProblema;
import Logica.SolicitudSoftware;
import java.util.LinkedList;

/**
 *
 * @author 2099340
 */
public class Facade {
    
    private final static Facade instance=new Facade();
    private DaoFactory factory = DaoFactory.getInstance();
    private Facade(){
        
    }
    
    public static Facade getInstance(){
        
        return instance;
    }
    
    public void registrarReporte(ReporteProblema pr){
        
    }
    
    public LinkedList<ReporteProblema> consultarProblemas(){
        return null;
    }
    
    public LinkedList<SolicitudSoftware> consultarSolicitudesSoftware(){
        return null;
    }
}
