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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;


/**
 *
 * @author 2101240
 */
public class FactoryMapper extends DaoFactory{

    
    
/*    SqlSession sql = null;
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
*/
   
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

    private static final ThreadLocal<Connection> connectionInstance = new ThreadLocal<Connection>() {
    };

    private static Properties appProperties = null;

    public FactoryMapper(Properties appProperties) {
        this.appProperties = appProperties;
    }

    private static Connection openConnection() throws PersistenceException, SQLException {
        String url = appProperties.getProperty("url");
        String driver = appProperties.getProperty("driver");
        String user = appProperties.getProperty("user");
        String pwd = appProperties.getProperty("pwd");

        try {
            Class.forName(driver);
            Connection _con = DriverManager.getConnection(url, user, pwd);
            _con.setAutoCommit(false);
            return _con;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new PersistenceException("Error on connection opening.", ex);
        }

    }

    @Override
    public void beginSession() throws PersistenceException {
        try {
            connectionInstance.set(openConnection());
        } catch (SQLException ex) {
            Logger.getLogger(FactoryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void endSession() throws PersistenceException {
        try {
            if (connectionInstance.get() == null || connectionInstance.get().isClosed()) {
                throw new PersistenceException("Conection is null or is already closed.");
            } else {
                connectionInstance.get().close();
            }
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.", ex);
        }
    }

    @Override
    public void commitTransaction() throws PersistenceException {
        try {
            if (connectionInstance.get() == null || connectionInstance.get().isClosed()) {
                throw new PersistenceException("Conection is null or is already closed.");
            } else {
                connectionInstance.get().commit();
            }
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.", ex);
        }
    }

    @Override
    public void rollbackTransaction() throws PersistenceException {
        try {
            if (connectionInstance.get() == null || connectionInstance.get().isClosed()) {
                throw new PersistenceException("Conection is null or is already closed.");
            } else {
                connectionInstance.get().rollback();
            }
        } catch (SQLException ex) {
            throw new PersistenceException("Error on connection closing.", ex);
        }
    }

  
    @Override
    public DaoLaboratorio getDaoLaboratorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DaoEquipo getDaoEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
