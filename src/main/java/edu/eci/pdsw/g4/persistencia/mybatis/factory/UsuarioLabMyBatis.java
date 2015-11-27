/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.g4.persistencia.mybatis.factory;

import edu.eci.pdsw.g4.logica.dao.DaoSoporteAcademico;
import edu.eci.pdsw.g4.logica.dao.DaoUsuarioLab;
import edu.eci.pdsw.g4.logica.estructura.SoporteAcademico;
import edu.eci.pdsw.g4.logica.estructura.UsuarioLab;
import edu.eci.pdsw.g4.persistencia.mybatis.mappers.UsuarioLabMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2100772
 */
public class UsuarioLabMyBatis implements DaoUsuarioLab{

    private UsuarioLabMapper ulmap=null;
    
    public UsuarioLabMyBatis(SqlSession session) {
        ulmap= session.getMapper(UsuarioLabMapper.class);
    }

    @Override
    public void save(UsuarioLab u) {
        ulmap.insertarUsuario(u);
    }

    @Override
    public UsuarioLab load(int num) {
        return ulmap.usuario(num);
    }

    @Override
    public void update(UsuarioLab u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(UsuarioLab u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<UsuarioLab> load() {
        return ulmap.usuarios();
    }

}