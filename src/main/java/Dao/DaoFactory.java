/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Dao;

import PersistenciaMybatis.FactoryMyBatis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



/**
 *
 * @author hcadavid
 */
public abstract class DaoFactory {
    
    protected DaoFactory(){}
    
     private static volatile DaoFactory instance = null;
    
    public static DaoFactory getInstance(Properties appProperties) {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                       instance = new FactoryMyBatis(appProperties);
                }
            }
        }
        return instance;
    }

    /*
        //EL ESQUEMA ANTERIOR ES UNA ALTERNATIVA AL MECANISMO DE FÁBRICA
        //ABSTRACTA VISTO ANTERIORMENTE:
        
        private static final DaoFactory instance=null;
    
        public static DaoFactory getInstance(){          
            if (instance=null){
                instance= ...
            }
            return instance;
        }
        
        //EN PRINCIPIO FUNCIONAN IGUAL, PERO EL NUEVO MECANISMO
        //GARANTIZA CONSISTENCIA CUANDO LA FÁBRICA SEA UTILIZADA
        //CONCURRENTEMENTE.
    */
    
    

    
    
    public abstract void beginSession() ;
    
    public abstract DaoEquipo getDaoEquipo();
    
    public abstract DaoLaboratorio getDaoLaboratorio();
    
    public abstract DaoReporteProblema getDaoReporteProblema();
    
    public abstract DaoSistemaOperativo getDaoSistemaOperativo();
    
    public abstract DaoSolicitudSoftware getDaoSolicitudSoftware();
    
    public abstract void commitTransaction() ;
    
    public abstract void rollbackTransaction() ;
    
    public abstract void endSession() ;

   
}
