/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.mappers;


import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Dario
 */
public interface LaboratorioMapper {
    @Select("Select * from Laboratorio where ID=#{id}")
         @Results(
            value={
            @Result(column="ID", property = "nombre"),
            @Result(column="Descripcion", property = "Descripcion")            }
         )
    Laboratorio getLaboratorio (@Param(value="id") String id);
    
    @Insert("insert into Laboratorio (ID, Descripcion) values(#{lb.nombre},#{lb.Descripcion})")
    int insertarLaboratorio(@Param(value="lb")Laboratorio lb);

    
    @Select("Select lab.ID as nombre, lab.Descripcion as Descripcion from Laboratorio as lab JOIN Equipo as eq ON lab.ID = eq.Laboratorio_Id JOIN ReporteProblema as rp ON eq.ID=rp.Equipo_ID")
         @Results(
            value={             
            @Result(column="nombre", property = "nombre"),
            @Result(column="Descripcion", property = "Descripcion")    
            }
         )
    public LinkedList<Laboratorio> getLaboratoriosProblemas();

    @Select("Select * from Laboratorio")
         @Results(
            value={             
            @Result(column="ID", property = "nombre"),
            @Result(column="Descripcion", property = "Descripcion")    
            }
         )
    public LinkedList<Laboratorio> getLaboratorios();
}
