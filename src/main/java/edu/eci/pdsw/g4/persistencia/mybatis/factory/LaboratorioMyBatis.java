/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.factory;

import edu.eci.pdsw.g4.logica.dao.DaoLaboratorio;
import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.LaboratorioMapper;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.ReporteProblemaMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2101240
 */
public class LaboratorioMyBatis implements DaoLaboratorio {

    
    private LaboratorioMapper rpmap=null;

    public LaboratorioMyBatis(SqlSession session) { 
        rpmap=session.getMapper(LaboratorioMapper.class);
    }
    
    
    @Override
    public void save(Laboratorio lb) {
        
        rpmap.insertarLaboratorio(lb);
    }

    @Override
    public Laboratorio load(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Laboratorio p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Laboratorio p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<ReporteProblema> load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Laboratorio> EquiposReportados() {
        return rpmap.getLaboratoriosProblemas();
    }
    public LinkedList<Laboratorio> getLaboratoriosProblemas(){
        return rpmap.getLaboratorios();
    }

    
}
