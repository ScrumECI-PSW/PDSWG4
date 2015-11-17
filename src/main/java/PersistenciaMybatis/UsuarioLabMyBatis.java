/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoSoporteAcademico;
import Dao.DaoUsuarioLab;
import Logica.SoporteAcademico;
import Logica.UsuarioLab;
import PersistenciaMybatysMappers.UsuarioLabMapper;
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