/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatysMappers;

import Logica.SoporteAcademico;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author 2100772
 */
public interface SoporteAcademicoMapper {
    
    @Select("Select * from SoporteAcademico where ID=#{num}")
    public SoporteAcademico solicitud(int num);
}
