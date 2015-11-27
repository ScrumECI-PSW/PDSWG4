/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.logica.dao;

import edu.eci.pdsw.g4.logica.estructura.Monitor;
import java.util.LinkedList;

/**
 *
 * @author 2100772
 */
public interface DaoMonitor {
    public void save(Monitor m) ;
    public Monitor load(int num);
    public void update (Monitor m);
    public void delete(Monitor m);
    public LinkedList<Monitor> load();
}
