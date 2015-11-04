/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoReporteProblema;
import Logica.ReporteProblema;
import PersistenciaMybatysMappers.ReporteProblemaMapper;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReporteProblema load(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ReporteProblema p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ReporteProblema p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<ReporteProblema> load() {
        return rpmap.reportesProblemas();
    }
    
}