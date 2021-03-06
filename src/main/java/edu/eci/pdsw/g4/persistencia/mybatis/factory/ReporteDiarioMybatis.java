/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.factory;

import edu.eci.pdsw.g4.logica.dao.DaoReporteDiario;
import edu.eci.pdsw.g4.logica.estructura.ReporteDiario;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.ReporteDiarioMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2099340
 */
public class ReporteDiarioMybatis implements DaoReporteDiario{

    private ReporteDiarioMapper rpmap=null;  
    
    public ReporteDiarioMybatis(SqlSession session) {
        rpmap=session.getMapper(ReporteDiarioMapper.class);
    }
    
    
    
    @Override
    public void insertarDiario(ReporteDiario lb) {
        rpmap.insertarDiario(lb);
    }
    
    @Override
    public void insertarDairioxProblema(ReporteDiario lb){
        rpmap.insertarDiarioxProblema(lb.getId(), lb.getReporteProblema().getId());
    }

    @Override
    public LinkedList<ReporteDiario> consultar(ReporteProblema rp) {
        return rpmap.Consultar(rp);
    }
    
}
