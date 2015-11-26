package edu.eci.cosw.sampleapp.test;

import Logica.Equipo;
import Logica.Facade.Facade;
import Logica.Laboratorio;
import Logica.Monitor;
import Logica.ReporteDiario;
import Logica.ReporteProblema;
import Logica.SoporteAcademico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;
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
        stmt.execute("delete from SoporteAcademico");
        stmt.execute("delete from DiarioxProblema");
        stmt.execute("delete from ReporteDiario");
        stmt.execute("delete from SistemaOperativo");
        stmt.execute("delete from SolicitudSoftware");
        stmt.execute("delete from ReporteProblema");
        stmt.execute("delete from EquipoXSistema");
        stmt.execute("delete from EquipoXSoftware");
        stmt.execute("delete from Equipo");
        stmt.execute("delete from Monitor");
        stmt.execute("delete from Laboratorio");
        
        
      
        conn.commit();
        conn.close();
    }

  @Test
  public void PersistenciaReporteProblemaTest() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("insert into Laboratorio values ('Redes','Hola Mundo')");
        conn.commit();
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values  (21,'Redes',true,'Hola Mundo')");
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
            if(rp.getId()==2101240 & rp.getEquipo().getId()==21 & rp.getEquipo().getLaboratorio().getNombre().equals("Redes")){
                count++;
            }
        }
        assertTrue("Reporte Problema incompletos sin equipo y sin laboratorio", count==2);
        
        conn.close();
  }
  @Test
  public void RegistroReporteProblemaTest() throws SQLException {
        
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
        assertTrue("error Reporte Problema con fecha", count==2);
       
  }
  
  
  @Test
  public void SegunLaboratorioReporteProblemaTest() throws SQLException {
        
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
        
        assertTrue("Error unico equipo, laboratorio y reporte problema", count==4);
       
        
  }
  
    /*
    El sistema debe informar acerca de problemas reportados que deben solucionarse
  */
  
   @Test
     public void IdentificacionDeProblemasSinResolverTest() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
                
        stmt.execute("insert into Laboratorio values ('Redes','Hola')");
        stmt.execute("insert into Laboratorio values ('Software','Laboratorio completo')");
        stmt.execute("insert into Laboratorio values ('Plataformas','Laboratorio')");
        conn.commit();
        
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (1,'Redes',true,'Ultima generacion')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (2,'Software',true,'Ultima generacion')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (3,'Plataformas',true,'Ultima generacion')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (4,'Redes',true,'Generacion 10.8')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (5,'Plataformas',true,'Generacion 7.15')");
        conn.commit();
        
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (1,1,'Esta dañado',true,'2014-10-12')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (2,2,'No tiene seguridad',true,'2014-11-04')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (3,3,'El equipo no prende',true,'2015-10-27')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (4,4,'Este equipo no tiene pluggins',true,'2015-09-22')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (5,5,'Esta dañado',false,'2011-09-23')");
        conn.commit();
        
        LinkedList cp=f.consultarProblemas();
        LinkedList<ReporteProblema> comparacion=new LinkedList<ReporteProblema>();
        int cont=0;
        Iterator<ReporteProblema> i =cp.iterator();
        
        while(i.hasNext()){
            ReporteProblema reporte=i.next();
            //Si el estado del reporte es TRUE significa que esta sin resolver
            if (reporte.getEstado()){
                comparacion.add(reporte);
            }
        }
        assertTrue(comparacion.size()==cp.size()-1);
        conn.close();
     }
     
     /*
        El sistema debe permitir al usuario identificar qué problema lleva más tiempo sin resolverse.
     */     
      @Test
     public void IdentificacionProblemasConMasTiempoSinResolverTest() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        
        stmt.execute("insert into Laboratorio values ('Redes', 'El inventario esta completo')");
        stmt.execute("insert into Laboratorio values ('Software','Laboratorio sin problemas')");
        stmt.execute("insert into Laboratorio values ('Seguridad','Laboratorio limpio')");
        conn.commit();
        
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (1,'Redes',true,'Ultima generacion')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (2,'Software',true,'Ultima generacion')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (3,'Seguridad',true,'Ultima generacion')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (4,'Redes',true,'Generacion 10.8')");
        stmt.execute("insert into Equipo (ID, Laboratorio_ID, Estado, Descripcion) values (5,'Seguridad',true,'Generacion 7.15')");
        conn.commit();
        
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (1,1,'Esta dañado',true,'2010-10-12')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (2,2,'No tiene seguridad',true,'2014-11-04')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (3,3,'El equipo no prende',true,'2015-10-27')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (4,4,'Este equipo no tiene pluggins',true,'2015-09-22')");
        stmt.execute("insert into ReporteProblema (ID, Equipo_ID,Descripcion, Estado, Fecha) values (5,5,'Esta dañado',false,'2011-09-23')");
        conn.commit();
        
        LinkedList<ReporteProblema> orden=f.problemasConMasTiempoSinResolver();
        
        assertTrue(orden.getFirst().getId()==1);
        
        conn.commit();
        conn.close();
     }
     
     /*Se realiza el registro de avances en un problema*/
     @Test
     public void RegistrarAvanceProblemaTest() throws SQLException {
       
        Laboratorio lb1=new Laboratorio("redes","holaMundo");
        Laboratorio lb=new Laboratorio("plataformas","holaMundo");
        Equipo eq= new Equipo(2101240,"holaMundo",true, lb);
        Equipo eq1= new Equipo(21012,"holaMundo",true, lb1);
        Equipo eq2= new Equipo(2101,"holaMundo",true, lb);
        ReporteProblema rpp=new ReporteProblema(eq, "Nofunciona", true,22,10,2015);
        ReporteDiario rpd=new ReporteDiario("A10%",rpp);
        ReporteDiario rpd1=new ReporteDiario("A50%",rpp);
        ReporteDiario rpd2=new ReporteDiario("A60%",rpp);
        
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        f.registrarLaboratorio(lb);
        f.registrarLaboratorio(lb1);
        f.registrarEquipo(eq);
        f.registrarEquipo(eq1);
        f.registrarEquipo(eq2);
        f.registrarReporte(rpp);
        f.registrarReporteDiario(rpd);
        f.registrarReporteDiario(rpd1);
        f.registrarReporteDiario(rpd2);
        LinkedList rd= f.consultarReporteDiario(rpp);
        Iterator<ReporteDiario> i= rd.iterator();
        int count=0;
        while (i.hasNext()){
            ReporteDiario r=i.next();
            if(rpd.getId()==r.getId() || rpd1.getId()==r.getId() || rpd2.getId()==r.getId())
            {
                count++;
            }
        }
        assertTrue("Avances incomletos" ,count==3);
     }
     
     
     /*
        Se deben poder reportar los soportes academicos realizados, indicando si fue solucionado (True) o no (False)
     */
     
      @Test
     public void ReportaSoporteAcademicoTest() throws SQLException {
        LOG.info("testReportaSoporteAcademicoTest()");
         Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        java.util.Date d = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(d.getDate());
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        
        Monitor m1=new Monitor(2100772,"Nicolas Guzman",6);
        Monitor m2=new Monitor(2101751,"Alejandro Villagladys",2);
        
        f.registrarMonitor(m1);
        f.registrarMonitor(m2);
     
        SoporteAcademico s1=new SoporteAcademico(2100772, true,"C++",fecha,"Desarrollo","Fue posible dar el soporte");
        SoporteAcademico s2=new SoporteAcademico(2101751, false,"Python",fecha,"Desarrollo","No fue posible dar el soporte porque no maneja el lenguaje");
        
                                          // id, int monitor_id, boolean solucionado, String lenguaje, Date fecha, String tema, String comentario
  
        f.registrarSoporte(s1);
        f.registrarSoporte(s2);
        
        LinkedList<SoporteAcademico> orden=f.consultaSoporteAcademico();
        
        assertTrue(orden.getFirst().isSolucionado() && orden.getLast().isSolucionado()==false);
        
     }
       
    
     /*
        El sistema debe permiter conocer si fue posible o no dar el soporte academico 
     */    
     
      @Test
     public void ConsultaSoporteAcademicoResueltoTest() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        Facade f=Facade.getInstance("h2-applicationconfig.properties");
        
        stmt.execute("insert into Monitor(Carnet,Nombre,Semestre) values (2098165,'Juan Carlos',6)");
        stmt.execute("insert into Monitor(Carnet,Nombre,Semestre) values (2100772,'Nicolas Guzman',6)");
        stmt.execute("insert into Monitor(Carnet,Nombre,Semestre) values (2101751,'Alejandro Villagladys',2)");
        stmt.execute("insert into Monitor(Carnet,Nombre,Semestre) values (2145075,'Leonardo',4)");
        
        stmt.execute("insert into SoporteAcademico(ID,Monitor_ID,Solucionado,Lenguaje,Fecha,Tema,Comentarios) values (1,2101751, false,'Programacion en Python','2015-09-23','Desarrollo','No fue posible dar el soporte porque no maneja el lenguaje')");
        stmt.execute("insert into SoporteAcademico(ID,Monitor_ID,Solucionado,Lenguaje,Fecha,Tema,Comentarios) values (2,2098165, true,'Programacion en mathematica','2015-09-23','Desarrollo','Fue posible dar el soporte')");
        stmt.execute("insert into SoporteAcademico(ID,Monitor_ID,Solucionado,Lenguaje,Fecha,Tema,Comentarios) values (3,2100772, true,'Programacion en C++','2015-09-23','Desarrollo','Fue posible dar el soporte')");
        stmt.execute("insert into SoporteAcademico(ID,Monitor_ID,Solucionado,Lenguaje,Fecha,Tema,Comentarios) values (4,2145075, true,'Programacion en java','2015-09-23','Desarrollo','Fue posible dar el soporte')");
        
        conn.commit();
        
        LinkedList<SoporteAcademico> orden=f.consultaSoporteAcademico();
        LinkedList<SoporteAcademico> resueltos=new LinkedList <SoporteAcademico>();
        
        Iterator<SoporteAcademico> i =orden.iterator();
        while(i.hasNext()){
            SoporteAcademico reporte=i.next();
            //Si el reporte esesta solucionado su atributo sera TRUE
            if (reporte.isSolucionado()){
                resueltos.add(reporte);
            }
        }
        assertTrue(orden.getFirst()!=resueltos.getFirst());
        conn.close();
     }
     
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());
} 

