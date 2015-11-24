/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;


import Logica.ReporteDiario;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2099340
 */
public interface ReporteDiarioMapper {
    
    @Insert("insert into Equipo (Descripcion) values(#{eq.descripcion})")
    @Options(useGeneratedKeys=true,keyProperty = "eq.id")
    void insertarDiario(@Param(value="eq")ReporteDiario lb);
}
