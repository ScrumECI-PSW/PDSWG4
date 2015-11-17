/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoSoporteAcademico;
import Logica.SoporteAcademico;
import PersistenciaMybatysMappers.SoporteAcademicoMapper;

/**
 *
 * @author 2100772
 */
public class SoporteAcademicoMyBatis implements DaoSoporteAcademico{

    private SoporteAcademicoMyBatis rp=null;
    
    public SoporteAcademicoMyBatis() {
        //rp= session.getMapper(SoporteAcademicoMapper.class);
    }

    @Override
    public void save(SoporteAcademico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SoporteAcademico load(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(SoporteAcademico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(SoporteAcademico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
