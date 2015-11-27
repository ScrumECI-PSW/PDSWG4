/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.mappers;

import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.logica.estructura.SistemaOperativo;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
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
public interface SistemaOperativoMapper {
    @Select("Select * from SistemaOperativo")
    @Results(
        value={
            @Result(column="ID", property = "id"),
            @Result(column="nombre", property = "nombre"),
            @Result(column="version", property = "version"),
        }
    )
    LinkedList<ReporteProblema> reportesProblemas();
    
    
    @Insert("Insert into SistemaOperativo (ID,nombre,version) values(#{so.id}, #{so.nombre}, #{so.version})")
    @Options(useGeneratedKeys=true,keyProperty = "so.id")
    int insertarSistemaOperativo(@Param(value="so")SistemaOperativo so);
    
    @Select("Select * from SistemaOperativo where ID=#{num}")
    public SistemaOperativo sistema(int num);

}
