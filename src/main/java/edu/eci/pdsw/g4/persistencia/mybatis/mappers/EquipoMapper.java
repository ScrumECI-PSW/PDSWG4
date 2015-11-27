/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.mappers;

import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Dario
 */
public interface EquipoMapper {
    
    @Select("Select * from Equipo where ID = #{n}")
    @Results(
            value = {
                @Result(column = "ID", property = "id"),
                @Result(column = "Descripcion", property = "descripcion"),
                @Result(column = "Estado", property = "estado"),
                @Result(property = "laboratorio", one = @One(select = "PersistenciaMybatysMappers.LaboratorioMapper.getLaboratorio"), column = "Laboratorio_ID")
            }
    )
    Equipo getEquipo(@Param(value = "n") int n);
    
    @Select("Select * from Equipo where Laboratorio_ID = #{n}")
    @Results(
            value = {
                @Result(column = "ID", property = "id"),
                @Result(column = "Descripcion", property = "descripcion"),
                @Result(column = "Estado", property = "estado"),
                @Result(property = "laboratorio", one = @One(select = "PersistenciaMybatysMappers.LaboratorioMapper.getLaboratorio"), column = "Laboratorio_ID")
            }
    )
    LinkedList<Equipo> getEquipoLab(@Param(value = "n") String n);
    
    
    @Insert("insert into Equipo (ID,Descripcion,Estado,Laboratorio_ID) values(#{eq.id},#{eq.descripcion},#{eq.estado},#{eq.laboratorio.nombre})")
    int insertarEquipo(@Param(value="eq")Equipo lb);

    @Select("Select * from Equipo as eq JOIN ReporteProblema as rp ON eq.ID=rp.Equipo_ID where eq.Laboratorio_ID = #{lab.nombre}")
    @Results(
            value = {
                @Result(column = "ID", property = "id"),
                @Result(column = "Descripcion", property = "descripcion"),
                @Result(column = "Estado", property = "estado"),
                @Result(property = "laboratorio", one = @One(select = "PersistenciaMybatysMappers.LaboratorioMapper.getLaboratorio"), column = "Laboratorio_ID")
            }
    )
    LinkedList<Equipo>  Reportados(@Param(value="lab")Laboratorio lab);
    
    
    
    
    @Update("update Equipo set Estado=#{eq.estado} where ID=#{eq.id} ")
    void update(@Param(value="eq")Equipo eq);
}
