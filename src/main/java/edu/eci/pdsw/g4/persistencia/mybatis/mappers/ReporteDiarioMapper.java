/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.mappers;


import edu.eci.pdsw.g4.logica.estructura.ReporteDiario;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import java.util.LinkedList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author 2099340
 */
public interface ReporteDiarioMapper {
    
    @Insert("insert into ReporteDiario (descripcion) values(#{eq.Descripcion})")
    @Options(useGeneratedKeys=true,keyProperty = "eq.id")
    void insertarDiario(@Param(value="eq")ReporteDiario lb);

    @Insert("insert into DiarioxProblema (ReporteDiario_ID, ReporteProblema_ID) values(#{rp},#{eq})")
    void insertarDiarioxProblema(@Param(value="rp")int lb , @Param(value="eq")int rp );
    
     
    @Select("Select rep.ID, rep.descripcion from ReporteDiario as rep JOIN DiarioxProblema as dp ON rep.ID = dp.ReporteDiario_ID JOIN ReporteProblema as rp ON rp.ID=dp.ReporteProblema_ID")
         @Results(
            value={             
            @Result(column="rep.ID", property = "id"),
            @Result(column="repo.descripcion", property = "Descripcion"),
            }
         )
    public LinkedList<ReporteDiario> Consultar(ReporteProblema rp);
    
    
    
}
