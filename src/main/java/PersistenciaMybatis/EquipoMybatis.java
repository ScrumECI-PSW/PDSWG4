/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoEquipo;
import Logica.Equipo;
import Logica.Laboratorio;
import Logica.ReporteProblema;
import PersistenciaMybatysMappers.EquipoMapper;
import PersistenciaMybatysMappers.LaboratorioMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2101240
 */
public class EquipoMybatis implements DaoEquipo{

    private EquipoMapper rpmap=null;

    public EquipoMybatis(SqlSession session) { 
        rpmap=session.getMapper(EquipoMapper.class);
    }
    
    @Override
    public void save(Equipo p) {
        rpmap.insertarEquipo(p);
    }

    @Override
    public Equipo load(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void update(Equipo p) {
        rpmap.update(p);
    }

    @Override
    public void delete(Equipo p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<ReporteProblema> load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList Reportados(Laboratorio lab) {
        return rpmap.Reportados(lab);
    }

    @Override
    public LinkedList EquiposPorLaboratorio(String n) {
        System.out.println("llamada base de datos");
        return rpmap.getEquipoLab(n);
    }

    

    
    
}
