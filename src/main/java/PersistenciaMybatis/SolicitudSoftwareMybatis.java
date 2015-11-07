/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaMybatis;

import Dao.DaoSolicitudSoftware;
import Logica.ReporteProblema;
import Logica.SolicitudSoftware;
import PersistenciaMybatysMappers.SolicitudSoftwareMapper;
import java.util.LinkedList;
import org.apache.ibatis.session.SqlSession;



/**
 *
 * @author 2101240
 */
public class SolicitudSoftwareMybatis implements DaoSolicitudSoftware {
    
    private SolicitudSoftwareMapper ssmap=null;
    
    public SolicitudSoftwareMybatis(SqlSession session) {
        ssmap=session.getMapper(SolicitudSoftwareMapper.class);
    }

    @Override
    public void save(SolicitudSoftware p) {
        ssmap.insertarSolicitud(p);
    }

    @Override
    public SolicitudSoftware load(int num) {
        return ssmap.solicitud(num);
    }

    @Override
    public void update(SolicitudSoftware p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(SolicitudSoftware p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<SolicitudSoftware> load() {
        return ssmap.solicitudes();
    }

    @Override
    public LinkedList<SolicitudSoftware> load(boolean estado) {
        return ssmap.soli(estado);
    }

   
    
}
