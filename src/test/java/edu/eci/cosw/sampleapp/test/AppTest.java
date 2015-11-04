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
        stmt.execute("delete from SistemaOperativo");
        stmt.execute("delete from SolicitudSoftware");
        stmt.execute("delete from ReporteProblema");
        stmt.execute("delete from EquipoXSistema");
        stmt.execute("delete from EquipoXSoftware");
        stmt.execute("delete from Equipo");
        stmt.execute("delete from Laboratorio");
        
        conn.commit();
        conn.close();
    }

  @Test
  public void sampleTest() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("insert into Laboratorio values ('1','Hola Mundo')");
        conn.commit();
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values  (21,'1',true,'Hola Mundo')");
        conn.commit();
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (2101240,21,'Hola Mundo',true,'2015-10-22')");
        conn.commit();
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        LinkedList cp=f.consultarProblemas();
        int count=0;
        Iterator<ReporteProblema> i =cp.iterator();
        
        while(i.hasNext()){
            ReporteProblema rp=i.next();
            if(rp.getId()==2101240 & rp.getEquipo().getId()==21 & rp.getEquipo().getLaboratorio().getNombre().equals("1")){
                count++;
            }
        }
        assertTrue(count==1);
        
        conn.close();
  }

} 

