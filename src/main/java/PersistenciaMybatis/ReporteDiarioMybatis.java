/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoReporteDiario;
import Logica.ReporteDiario;
import Logica.ReporteProblema;
import PersistenciaMybatysMappers.ReporteDiarioMapper;
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
    
    public void insertarDairioxProblema(ReporteDiario lb){
        System.out.println(lb.getId() +" "+ lb.getReporteProblema().getId());
        rpmap.insertarDiarioxProblema(lb.getId(), lb.getReporteProblema().getId());
    }

    @Override
    public LinkedList<ReporteDiario> consultar(ReporteProblema rp) {
        return rpmap.Consultar(rp);
    }
    
}
