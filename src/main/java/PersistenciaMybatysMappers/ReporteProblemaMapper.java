/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;

import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
            @Result(property = "equipo",one = @One(select ="PersistenciaMybatysMappers.EquipoMapper.getEquipo"),column="Equipo_ID")
        }
    )
    LinkedList<Logica.ReporteProblema> reportesProblemas();
    
}
