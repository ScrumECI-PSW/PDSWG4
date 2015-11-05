/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;

import Logica.SolicitudSoftware;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Dario
 */
public interface SolicitudSoftwareMapper {
    
    @Insert("Insert into SolicitudSoftware (Descripcion, Enlaces, Estado, Fecha, Justificacion) values(#{ss.descripćion}, #{ss.enlaces}, #{ss.estado}. #{ss.fecha}, #{ss.justificacion})")
    @Options(useGeneratedKeys=true,keyProperty = "ss.id")
    public void insertarSolicitud(@Param(value="ss")SolicitudSoftware p);
    
    @Select("Select * from SolicitudSoftware where ID=#{num}")
    public SolicitudSoftware solicitud(int num);
    
    @Select("Select * from SolicitudSoftware")
    @Results(
        value={
            @Result(column="ID", property="id"),
            @Result(column="Descripcion", property="descripcion"),
            @Result(column="Enlaces", property="enlaces"),
            @Result(column="Estado", property="estado"),
            @Result(column="Fecha", property="fecha"),
            @Result(column="Justificacion", property="justificacion")
        }
    )
    public LinkedList<SolicitudSoftware> solicitudes();
    
    
    @Select("Select * from SolicitudSoftware where Estado=#{estado}")
    @Results(
        value={
            @Result(column="ID", property="id"),
            @Result(column="Descripcion", property="descripcion"),
            @Result(column="Enlaces", property="enlaces"),
            @Result(column="Estado", property="estado"),
            @Result(column="Fecha", property="fecha"),
            @Result(column="Justificacion", property="justificacion")
        }
    )
    public LinkedList<SolicitudSoftware> solicitudes(boolean estado);
    
}
