/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import Logica.SoporteAcademico;
import java.util.LinkedList;

/**
 *
 * @author 2100772
 */
public interface DaoSoporteAcademico {
    public void save(SoporteAcademico s) ;
    public SoporteAcademico load(int num);
    public void update (SoporteAcademico s);
    public void delete(SoporteAcademico s);
    public LinkedList<SoporteAcademico> load();
    public LinkedList<SoporteAcademico> load(boolean solucionado);
}
