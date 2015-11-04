/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;

import Logica.Equipo;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Dario
 */
public interface EquipoMapper {

    @Select("Select * from Equipo where Laboratorio_ID=#{id}")
    @Results(
            value = {
                @Result(column = "ID", property = "id"),
                @Result(column = "Fecha", property = "fecha"),
                @Result(column = "Estado", property = "estado"),
                @Result(property = "laboratorio", one = @One(select = "PersistenciaMybatysMappers.LaboratorioMapper.getLaboratorio"), column = "Laboratorio_ID")
            }
    )
    LinkedList<Equipo> getEquipos(@Param(value = "id") String id);

    
    
    
    
    
    @Select("Select * from Equipo where ID = #{n}")
    @Results(
            value = {
                @Result(column = "ID", property = "id"),
                @Result(column = "Fecha", property = "fecha"),
                @Result(column = "Estado", property = "estado"),
                @Result(property = "laboratorio", one = @One(select = "PersistenciaMybatysMappers.LaboratorioMapper.getLaboratorio"), column = "Laboratorio_ID")
            }
    )
    Equipo getEquipo(@Param(value = "n") int n);
}
