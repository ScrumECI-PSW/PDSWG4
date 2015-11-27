/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.factory;

import edu.eci.pdsw.g4.logica.dao.DaoReporteProblema;
import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.ReporteProblemaMapper;
import java.util.LinkedList;

import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2101240
 */
public class ReporteProblemaMybatis implements DaoReporteProblema {

    
    private ReporteProblemaMapper rpmap=null;

    public ReporteProblemaMybatis(SqlSession session) { 
        rpmap=session.getMapper(ReporteProblemaMapper.class);
    }
    
    
    @Override
    public void save(ReporteProblema p) {
        rpmap.insertarReportesProblemas(p);
    }

    @Override
    public ReporteProblema load(int num) {
        return rpmap.reporte(num);
    }

    @Override
    public void update(ReporteProblema p) {
        rpmap.update(p);
    }

    @Override
    public void delete(ReporteProblema p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<ReporteProblema> load() {
        return rpmap.reportesProblemas();
    }

    @Override
    public LinkedList Reportes(Equipo eqq) {
        return rpmap.reportesProb(eqq);
    }
    
}
