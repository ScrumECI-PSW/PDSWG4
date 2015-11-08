/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoSistemaOperativo;
import Logica.ReporteProblema;
import Logica.SistemaOperativo;
import PersistenciaMybatysMappers.SistemaOperativoMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2101240
 */
public class SistemaOperativoMybatis implements DaoSistemaOperativo{
    
    private SistemaOperativoMapper som=null;
    
    SistemaOperativoMybatis(SqlSession session) {
        som= session.getMapper(SistemaOperativoMapper.class);
    }

    @Override
    public void save(SistemaOperativo o) {
        som.insertarSistemaOperativo(o);
    }

    @Override
    public SistemaOperativo load(int num) {
        return som.sistema(num);
    }

    @Override
    public void update(SistemaOperativo p) {
        throw new UnsupportedOperationException("Sin implementar el metodo Update en Mybatis"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(SistemaOperativo p) {
        throw new UnsupportedOperationException("Sin implementar el metodo delete en Mybatis"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<ReporteProblema> load() {
        throw new UnsupportedOperationException("Sin implementar el metodo load que retorna una LinkedList en Mybatis"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
