/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;


import Logica.Laboratorio;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
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
            @Result(column="Descripcion", property = "Descripcion"),
            @Result(property = "Equipos",one = @One(select ="PersistenciaMybatysMappers.EquipoMapper.getEquipos"),column="Laboratorio_ID")
            }
         )
    Laboratorio getLaboratorio (@Param(value="id") int id);
}
