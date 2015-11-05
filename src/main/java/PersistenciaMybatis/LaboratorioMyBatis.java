/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoLaboratorio;
import Logica.Laboratorio;
import Logica.ReporteProblema;
import PersistenciaMybatysMappers.LaboratorioMapper;
import PersistenciaMybatysMappers.ReporteProblemaMapper;
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
    
}
