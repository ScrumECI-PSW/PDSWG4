-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-10-29 21:10:11.591




-- tables
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







-- End of file.
