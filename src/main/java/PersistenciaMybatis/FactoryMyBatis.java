

package PersistenciaMybatis;

import Dao.DaoEquipo;
import Dao.DaoFactory;
import Dao.DaoLaboratorio;
import Dao.DaoReporteDiario;
import Dao.DaoReporteProblema;
import Dao.DaoSistemaOperativo;
import Dao.DaoSolicitudSoftware;
import Dao.DaoSoporteAcademico;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 *
 * @author 2101240
 */
public class FactoryMyBatis extends DaoFactory{

    
    
private static volatile SqlSessionFactory sessionFactory;
    
   
    
    private SqlSession currentSession=null;
  
   private SqlSessionFactory getSqlSessionFactory(Properties appProperties) {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(appProperties.getProperty("mybatis-config-file"));
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory;
    }

    private static Properties appProperties = null;

    
    public  FactoryMyBatis(Properties appProperties) {
        this.appProperties=appProperties;
        if (sessionFactory==null){
            synchronized( FactoryMyBatis.class){
                if (sessionFactory==null){
                    sessionFactory=getSqlSessionFactory(this.appProperties); 
                }
            }
           
        }
    }
    
    @Override
    public DaoSolicitudSoftware getDaoSolicitudSoftware() {
        return new SolicitudSoftwareMybatis(currentSession);
    }

     @Override
    public DaoReporteProblema getDaoReporteProblema() {
        return new ReporteProblemaMybatis(currentSession);
    }

    @Override
    public DaoSistemaOperativo getDaoSistemaOperativo() {
        return new SistemaOperativoMybatis(currentSession);
    }
    
    @Override
    public void beginSession() throws PersistenceException {
        currentSession=sessionFactory.openSession();
    }

    @Override
    public void endSession() throws PersistenceException {
        currentSession.close();
    }

    @Override
    public void commitTransaction() throws PersistenceException {
        currentSession.commit();
    }

    @Override
    public void rollbackTransaction() throws PersistenceException {
        currentSession.rollback();
    }

  
    @Override
    public DaoLaboratorio getDaoLaboratorio() {
        return new LaboratorioMyBatis(currentSession);
    }

    @Override
    public DaoEquipo getDaoEquipo() {
        return new EquipoMybatis(currentSession);
    }

    @Override
    public DaoSoporteAcademico getDaoSoporteAcademico() {
        return new SoporteAcademicoMyBatis(currentSession);
    }

    @Override
    public DaoReporteDiario getDaoReporteDiario() {
        return new ReporteDiarioMybatis(currentSession);
    }

}