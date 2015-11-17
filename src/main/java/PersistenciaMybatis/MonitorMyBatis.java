/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoMonitor;
import Logica.Monitor;
import PersistenciaMybatysMappers.MonitorMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2100772
 */
public class MonitorMyBatis implements DaoMonitor {
    
    private MonitorMyBatis rp=null;

    public MonitorMyBatis(SqlSession session) {
       // rp= session.getMapper(MonitorMapper.class);
    }
    
    @Override
    public void save(Monitor m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Monitor load(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Monitor m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Monitor m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
