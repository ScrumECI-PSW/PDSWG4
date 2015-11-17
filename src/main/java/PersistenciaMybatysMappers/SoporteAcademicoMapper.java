/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;

import Logica.SoporteAcademico;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author 2100772
 */
public interface SoporteAcademicoMapper {
    
    @Insert("Insert into SoporteAcademico (ID, Monitor_ID, Solucionado, Lenguaje, Fecha, Tema, Comentarios) values(#{sa.id}, #{sa.monitor_id}, #{sa.solucionado}, #{sa.lenguaje}, #{sa.fecha}, #{sa.tema}, #{sa.comentario})")
    public void insertarSoporte(@Param(value="sa")SoporteAcademico s);

    @Select("Select * from SoporteAcademico where ID=#{num}")
    public SoporteAcademico soporte(int num);

    @Select("Select * from SoporteAcademico")
    @Results(
        value={
            @Result(column="ID", property="id"),
            @Result(column="Monitor_ID", property="monitor_id"),
            @Result(column="Solucionado", property="solucionado"),
            @Result(column="Lenguaje", property="lenguaje"),
            @Result(column="Fecha", property="fecha"),
            @Result(column="Tema", property="tema"),
            @Result(column="Comentarios", property="comentario")
        }
    )
    public LinkedList<SoporteAcademico> soportes();
    
    @Select("Select * from SoporteAcademico where solucionado=#{solucionado}")
    @Results(
        value={
            @Result(column="ID", property="id"),
            @Result(column="Monitor_ID", property="monitor_id"),
            @Result(column="Solucionado", property="solucionado"),
            @Result(column="Lenguaje", property="lenguaje"),
            @Result(column="Fecha", property="fecha"),
            @Result(column="Tema", property="tema"),
            @Result(column="Comentarios", property="comentario")
        }
    )
    public LinkedList<SoporteAcademico> soportesSinSolucionar(boolean solucionado);
}
