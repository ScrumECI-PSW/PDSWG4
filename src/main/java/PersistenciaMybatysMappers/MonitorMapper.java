/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;

import Logica.Monitor;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author 2100772
 */
public interface MonitorMapper {
    
    @Insert("Insert into Monitor (Carnet, Nombre, Semestre) values (#{moni.carnet}, #{moni.nombre}, #{moni.semestre})")
    public void insertarMonitor(@Param(value="moni")Monitor m);
    
    @Select("Select * from Monitor where Carnet=#{num}")
    public Monitor monitor(int num);

    @Select("Select * from Monitor")
    @Results(
        value={
            @Result(column="Carnet", property="carnet"),
            @Result(column="Nombre", property="nombre"),
            @Result(column="Semestre", property="semestre")
        }
    )
    public LinkedList<Monitor> monitores();
    
}
