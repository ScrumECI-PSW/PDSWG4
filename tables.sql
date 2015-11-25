-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-10-29 21:10:11.591




-- tables
-- Table DiarioxProblema
CREATE TABLE DiarioxProblema (
    ReporteProblema_ID int  NOT NULL,
    ReporteDiario_ID int  NOT NULL,
    CONSTRAINT DiarioxProblema_pk PRIMARY KEY (ReporteProblema_ID,ReporteDiario_ID)
);

-- Table ReporteDiario
CREATE TABLE ReporteDiario (
    ID int  NOT NULL  AUTO_INCREMENT,
    descripcion char(250)  NOT NULL,
    CONSTRAINT ReporteDiario_pk PRIMARY KEY (ID)
);


-- Table Equipo
CREATE TABLE Equipo (
    ID int  NOT NULL  AUTO_INCREMENT,
    Laboratorio_ID varchar(50)  NOT NULL,
    Estado bool  NOT NULL,
    Descripcion char(250)  NOT NULL,
    CONSTRAINT Equipo_pk PRIMARY KEY (ID)
);

-- Table EquipoXSistema
CREATE TABLE EquipoXSistema (
    Equipo_ID int  NOT NULL,
    SistemaOperativo_ID int  NOT NULL,
    CONSTRAINT EquipoXSistema_pk PRIMARY KEY (Equipo_ID,SistemaOperativo_ID)
);

-- Table EquipoXSoftware
CREATE TABLE EquipoXSoftware (
    Equipo_ID int  NOT NULL,
    SolicitudSoftware_ID int  NOT NULL,
    CONSTRAINT EquipoXSoftware_pk PRIMARY KEY (Equipo_ID,SolicitudSoftware_ID)
);

-- Table Laboratorio
CREATE TABLE Laboratorio (
    ID varchar(50)  NOT NULL,
    Descripcion char(255)  NOT NULL,
    CONSTRAINT Laboratorio_pk PRIMARY KEY (ID)
);

-- Table ReporteProblema
CREATE TABLE ReporteProblema (
    ID int  NOT NULL  AUTO_INCREMENT,
    Equipo_ID int  NOT NULL,
    Descripcion char(255)  NOT NULL,
    Estado bool  NOT NULL,
    Fecha date  NOT NULL,
    CONSTRAINT ReporteProblema_pk PRIMARY KEY (ID)
);

-- Table SistemaOperativo
CREATE TABLE SistemaOperativo (
    ID int  NOT NULL  AUTO_INCREMENT,
    nombre varchar(50)  NOT NULL,
    version varchar(100)  NOT NULL,
    CONSTRAINT SistemaOperativo_pk PRIMARY KEY (ID)
);

-- Table SolicitudSoftware
CREATE TABLE SolicitudSoftware (
    ID int  NOT NULL  AUTO_INCREMENT,
    Descripcion char(255)  NOT NULL,
    Enlaces char(255)  NOT NULL,
    Estado bool  NOT NULL,
    Fecha date  NOT NULL,
    Justificacion char(255)  NOT NULL,
    CONSTRAINT SolicitudSoftware_pk PRIMARY KEY (ID)
);

--Table SoporteAcademico
CREATE TABLE SoporteAcademico (
    ID int  NOT NULL  AUTO_INCREMENT,
    Monitor_ID int NOT NULL,
    Solucionado bool  NOT NULL,
    Lenguaje varchar(50) NOT NULL,
    Fecha date  NOT NULL,
    Tema char(255)  NOT NULL,
    Comentarios char(255)  NOT NULL,
    CONSTRAINT SoporteAcademico_pk PRIMARY KEY (ID)
);

--Table Monitor
CREATE TABLE Monitor (
    Carnet int  NOT NULL,
    Nombre varchar(50) NOT NULL,
    Semestre int  NOT NULL,
    CONSTRAINT Monitor_pk PRIMARY KEY (Carnet)
);

--Table UsuarioLab
CREATE TABLE UsuarioLab (
    Carnet int  NOT NULL,
    Nombre varchar(50) NOT NULL,
    Semestre int  NOT NULL,
    CONSTRAINT UsuarioLab_pk PRIMARY KEY (Carnet)
);


-- foreign keys
-- Reference:  DiarioxProblema_ReporteDiario (table: DiarioxProblema)


ALTER TABLE DiarioxProblema ADD CONSTRAINT DiarioxProblema_ReporteDiario FOREIGN KEY  (ReporteDiario_ID)
    REFERENCES ReporteDiario (ID);
-- Reference:  DiarioxProblema_ReporteProblema (table: DiarioxProblema)


ALTER TABLE DiarioxProblema ADD CONSTRAINT DiarioxProblema_ReporteProblema FOREIGN KEY  (ReporteProblema_ID)
    REFERENCES ReporteProblema (ID);
-- Reference:  EquipoXSistema_Equipo (table: EquipoXSistema)



-- Reference:  EquipoXSistema_Equipo (table: EquipoXSistema)
ALTER TABLE EquipoXSistema ADD CONSTRAINT EquipoXSistema_Equipo FOREIGN KEY (Equipo_ID)
    REFERENCES Equipo (ID);
-- Reference:  EquipoXSistema_SistemaOperativo (table: EquipoXSistema)


ALTER TABLE EquipoXSistema ADD CONSTRAINT EquipoXSistema_SistemaOperativo FOREIGN KEY (SistemaOperativo_ID)
REFERENCES SistemaOperativo (ID);
-- Reference:  EquipoXSoftware_Equipo (table: EquipoXSoftware)


ALTER TABLE EquipoXSoftware ADD CONSTRAINT EquipoXSoftware_Equipo FOREIGN KEY (Equipo_ID)
REFERENCES Equipo (ID);
-- Reference:  EquipoXSoftware_SolicitudSoftware (table: EquipoXSoftware)


ALTER TABLE EquipoXSoftware ADD CONSTRAINT EquipoXSoftware_SolicitudSoftware FOREIGN KEY (SolicitudSoftware_ID)
REFERENCES SolicitudSoftware (ID);
-- Reference:  Equipo_Laboratorio (table: Equipo)


ALTER TABLE Equipo ADD CONSTRAINT Equipo_Laboratorio FOREIGN KEY (Laboratorio_ID)
REFERENCES Laboratorio (ID);
-- Reference:  Reporte_Equipo (table: ReporteProblema)


ALTER TABLE ReporteProblema ADD CONSTRAINT Reporte_Equipo FOREIGN KEY (Equipo_ID)
REFERENCES Equipo (ID);

ALTER TABLE SoporteAcademico ADD CONSTRAINT SoporteAcademico_Monitor FOREIGN KEY (Monitor_ID)
    REFERENCES Monitor (Carnet);
-- Reference:  SoporteAcademico (table: SoporteAcademico)




-- End of file.
