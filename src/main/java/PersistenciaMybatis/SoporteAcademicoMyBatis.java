/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoSoporteAcademico;
import Logica.SoporteAcademico;
import PersistenciaMybatysMappers.SoporteAcademicoMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2100772
 */
public class SoporteAcademicoMyBatis implements DaoSoporteAcademico{

    private SoporteAcademicoMapper samap=null;
    
    public SoporteAcademicoMyBatis(SqlSession session) {
        samap= session.getMapper(SoporteAcademicoMapper.class);
    }

    @Override
    public void save(SoporteAcademico s) {
        samap.insertarSoporte(s);
    }

    @Override
    public SoporteAcademico load(int num) {
        return samap.soporte(num);
    }

    @Override
    public void update(SoporteAcademico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(SoporteAcademico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<SoporteAcademico> load() {
        return samap.soportes();
    }

    @Override
    public LinkedList<SoporteAcademico> load(boolean solucionado) {
        return samap.soportesSinSolucionar(solucionado); 
    }
    
}
