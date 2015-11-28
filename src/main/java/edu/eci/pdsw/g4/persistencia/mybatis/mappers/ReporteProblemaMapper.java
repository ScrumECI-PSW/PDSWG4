/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.mappers;

import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Dario
 */
public interface ReporteProblemaMapper {
    @Select("Select * from ReporteProblema")
    @Results(
        value={
            @Result(column="ID", property = "id"),
            @Result(column="Fecha", property = "fecha"),
            @Result(column="Descripcion", property = "descripcion"),
            @Result(property = "equipo",one = @One(select ="edu.eci.pdsw.g4.persistencia.mybatis.mappers.EquipoMapper.getEquipo"),column="Equipo_ID")
        }
    )
    LinkedList<ReporteProblema> reportesProblemas();
    
    @Insert("Insert into ReporteProblema (Equipo_ID,Descripcion, Estado, Fecha) values(#{rp.equipo.id}, #{rp.descripcion}, #{rp.estado}, #{rp.fecha})")
    @Options(useGeneratedKeys=true,keyProperty = "rp.id")
    int insertarReportesProblemas(@Param(value="rp")ReporteProblema rp);

    
    
    
    @Select("Select * from ReporteProblema where Equipo_ID=#{eqq.id}")
    @Results(
        value={
            @Result(column="ID", property = "id"),
            @Result(column="Fecha", property = "fecha"),
            @Result(column="Descripcion", property = "descripcion"),
            @Result(column="estado", property = "estado"),
            @Result(property = "equipo",one = @One(select ="edu.eci.pdsw.g4.persistencia.mybatis.mappers.EquipoMapper.getEquipo"),column="Equipo_ID")
        }
    )
    LinkedList<ReporteProblema> reportesProb(@Param(value="eqq") Equipo eqq);

    @Select("Select * from ReporteProblema where ID=#{eqq}")
    @Results(
        value={
            @Result(column="ID", property = "id"),
            @Result(column="Fecha", property = "fecha"),
            @Result(column="Descripcion", property = "descripcion"),
            @Result(column="estado", property = "estado"),
            @Result(property = "equipo",one = @One(select ="edu.eci.pdsw.g4.persistencia.mybatis.mappers.EquipoMapper.getEquipo"),column="Equipo_ID")
        }
    )
    ReporteProblema reporte(@Param(value="eqq") int eqq);
    
    
    @Update("Update ReporteProblema set Estado=false where ID=#{pro.id}")
    public void update(@Param(value="pro")ReporteProblema prob); 
    
    
    
    
}
