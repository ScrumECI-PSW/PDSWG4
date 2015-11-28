/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.factory;

import edu.eci.pdsw.g4.logica.dao.DaoEquipo;
import edu.eci.pdsw.g4.logica.estructura.Equipo;
import edu.eci.pdsw.g4.logica.estructura.Laboratorio;
import edu.eci.pdsw.g4.logica.estructura.ReporteProblema;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.EquipoMapper;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.LaboratorioMapper;
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
        return rpmap.getEquipoLab(n);
    }

    

    
    
}
