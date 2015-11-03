/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Facade;

import Dao.DaoFactory;
import Logica.ReporteProblema;
import Logica.SolicitudSoftware;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author 2099340
 */
public class Facade {
    
    
    private static Facade instance=null;
    
    private final Properties properties=new Properties();
    
    private Facade(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
    }
    
    public static Facade getInstance(String propertiesFileName) throws RuntimeException{
        if (instance==null){
            try {
                instance=new Facade(propertiesFileName);
            } catch (IOException ex) {
                throw new RuntimeException("Error on application configuration:",ex);
            }
        }        
        return instance;
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
