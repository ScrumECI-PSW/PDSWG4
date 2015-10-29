/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatys;

import Dao.DaoEquipo;
import Dao.DaoFactory;
import Dao.DaoLaboratorio;
import Dao.DaoReporteProblema;
import Dao.DaoSistemaOperativo;
import Dao.DaoSolicitudSoftware;


/**
 *
 * @author 2101240
 */
public class FactoryMapper extends DaoFactory{
    SqlSession sql = null;
    @Override
    public void beginSession()  {
        SqlSessionFactory sqlSessionFactory = null;
        if(sqlSessionFactory == null){
            InputStream inputStream;
            try{
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch(IOException e){
                throw new RuntimeException(e.getCause());
            }
        }
        sql = sqlSessionFactory.openSession();
    }

    @Override
    public DaoEquipo getDaoProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoLaboratorio getDaoPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoReporteProblema getDaoReporteProblema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoSistemaOperativo getDaoSistemaOperativo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoSolicitudSoftware getDaoSolicitudSoftware() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commitTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endSession() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
