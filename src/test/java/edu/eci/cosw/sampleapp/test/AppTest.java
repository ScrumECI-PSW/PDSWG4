package edu.eci.cosw.sampleapp.test;

import Logica.Facade.Facade;
import Logica.ReporteProblema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;

import org.junit.Test;

public class AppTest {

     @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from Equipo");
        stmt.execute("delete from EquipoXSistema");
        stmt.execute("delete from EquipoXSoftware");
        stmt.execute("delete from Laboratorio");
        stmt.execute("delete from ReporteProblema");
        stmt.execute("delete from SistemaOperativo");
        stmt.execute("delete from SolicitudSoftware");
           
        conn.commit();
        conn.close();
    }

  @Test
  public void sampleTest() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("insert into ReporteProblema values (2101240,21,'Hola Mundo',true,'2015-10-22')");
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        LinkedList cp=f.consultarProblemas();
        Iterator<ReporteProblema> i =cp.iterator();
        int count=0;
        while(i.hasNext()){
            ReporteProblema rp=i.next();
            if(rp.getId()==2101240){
                count++;
            }
        }
        assertTrue(count==1);
        
        conn.commit();
        conn.close();
  }

} 

