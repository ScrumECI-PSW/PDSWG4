package edu.eci.cosw.sampleapp.test;

import Logica.Equipo;
import Logica.Facade.Facade;
import Logica.Laboratorio;
import Logica.ReporteProblema;
import java.sql.Connection;
import java.sql.Date;
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
  public void PersistenciaReporteProblema() throws SQLException {
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
            count++;
            if(rp.getId()==2101240 & rp.getEquipo().getId()==21 & rp.getEquipo().getLaboratorio().getNombre().equals("1")){
                count++;
            }
        }
        assertTrue(count==2);
        
        conn.close();
  }
  @Test
  public void RegistroReporteProblema() throws SQLException {
        
        Laboratorio lb=new Laboratorio("1","holaMundo");
        Equipo eq= new Equipo(2101240,"holaMundo",true, lb);
        ReporteProblema rpp=new ReporteProblema(eq, "HOLAMUNDO", true,22,10,2015);
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        f.registrarLaboratorio(lb);
        f.registrarEquipo(eq);
        f.registrarReporte(rpp);
        LinkedList cp=f.consultarProblemas();
        int count=0;
        Iterator<ReporteProblema> i =cp.iterator();
        
        while(i.hasNext()){
            ReporteProblema rp=i.next();
            count++;
            if(rp.getFecha().getDay()==rpp.getFecha().getDay() & rp.getFecha().getMonth()==rpp.getFecha().getMonth() & rp.getFecha().getYear()==rpp.getFecha().getYear()& rp.getDescripcion().equals(rpp.getDescripcion())& rp.getEquipo().getId()==2101240 & rp.getEquipo().getLaboratorio().getNombre().equals("1") ){ 
                count++;
            }
        }
        assertTrue(count==2);
       
        
  }
  
  
  @Test
  public void SegunLaboratorioReporteProblema() throws SQLException {
        
        Laboratorio lb1=new Laboratorio("2","holaMundo");
        Laboratorio lb=new Laboratorio("1","holaMundo");
        Equipo eq= new Equipo(2101240,"holaMundo",true, lb);
        Equipo eq1= new Equipo(21012,"holaMundo",true, lb1);
        Equipo eq2= new Equipo(2101,"holaMundo",true, lb);
        ReporteProblema rpp=new ReporteProblema(eq, "HOLAMUNDO", true,22,10,2015);
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        f.registrarLaboratorio(lb);
        f.registrarLaboratorio(lb1);
        f.registrarEquipo(eq);
        f.registrarEquipo(eq1);
        f.registrarEquipo(eq2);
        f.registrarReporte(rpp);
        
        LinkedList clb=f.consultarLaboratoriosConEquipoReporteProblemas();
        Iterator<Laboratorio> ii = clb.iterator();
        int count=0;
        while(ii.hasNext()){
            Laboratorio lab=ii.next();
            count++;
            if(lab.getNombre().equals("1")){
                LinkedList cpp=f.consultarEquiposProblemasLab(lab);
                Iterator<Equipo> iii = cpp.iterator();
                while(iii.hasNext()){
                    count++;
                    Equipo eqq=iii.next();
                    if(eqq.getId()==2101240){
                        LinkedList cppp=f.consultarReporteProblemasEquipos(eqq);
                        Iterator<ReporteProblema> iiii = cppp.iterator();
                        while(iiii.hasNext()){
                            count++;
                            ReporteProblema eqqq=iiii.next();
                            if(eqqq.getFecha().getDay()==rpp.getFecha().getDay() & eqqq.getFecha().getMonth()==rpp.getFecha().getMonth() & eqqq.getFecha().getYear()==rpp.getFecha().getYear()& rpp.getDescripcion().equals(eqqq.getDescripcion())){
                             count++;
                            }
                          } 
                    }
                }
            }
        }        
        
        assertTrue(count==4);
       
        
  }
  

} 

