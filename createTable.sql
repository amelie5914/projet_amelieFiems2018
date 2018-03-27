/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ameliefiems
 * Created: 16-mars-2018
 */

CREATE TABLE Entreprise
(idEnt number constraint ent_pk PRIMARY KEY,
nomEnt varchar2(30) constraint ent_nom_uk UNIQUE ,
telEnt varchar2(12) constraint ent_tel_check CHECK(regexp_like(telEnt
,'^0[[:digit:]]{2}\/[[:digit:]]{2}\.[[:digit:]]{2}\.[[:digit:]]{2}$'),
adresse varchar2(70));

CREATE TABLE Projet
(
    idProj number constraint proj_pk PRIMARY KEY,
    idCli number constraint proj_idCli_fk FOREIGN KEY (idCli) REFERENCES Entreprise (idEnt),
    titre varchar2(40) constraint proj_titre_uk UNIQUE,
    dateDebut DATE ,
    dateFin DATE
);

CREATE TABLE Travail
(   
    idTrav number constraint trav_pk PRIMARY KEY,
    idProj number constraint trav_idProj_fk FOREIGN KEY (idProj) REFERENCES Projet(idProj),
    idMem number constraint trav_idMem_fk FOREIGN KEY (idMem) REFERENCES Membre(idMem),
    dateEng DATE,
    taux number (3)
);

CREATE TABLE Membre
(
    idMem number constraint mem_pk PRIMARY KEY,
    nomMem varchar2(30),
    prenomMen varchar2(30),
    telMem varchar2(12) constraint mem_tel_check CHECK(regexp_like(telMem,'^0[[:digit:]]{2}\/[[:digit:]]{2}\.[[:digit:]]{2}\.[[:digit:]]{2}$'),
    email varchar2(30) constraint mem_email_check CHECK (regexp_like(email,'^[[:alnum:]]+@[[:alpha:]]+\.[[:alpha:]]{2,3}$')),

);

CREATE TABLE Competence
(
    idComp number constraint com_pk PRIMARY KEY,
    idNiv number (1) constraint comp_idNiv_fk FOREIGN KEY (idNiv) REFERENCES Niveau(idNiv),
    idMem number constraint comp_idMem_fk FOREIGN KEY (idMem) REFERENCES Membre(idMem),
    idDis number constraint comp_idDis_fk FOREIGN KEY (idDis) REFERENCES Discipline(idDis)
);
CREATE TABLE Niveau
(
    idNiv number constraint niv_pk PRIMARY KEY,
    degre number(1) constraint comp_degre_check CHECK(degre=1 or degre=2 or degre=3),
    signification varchar2(70)
);
CREATE TABLE Discipline
(
    idDis number constraint dis_pk PRIMARY KEY,
    nomDis varchar2(10)
);
CREATE TABLE Temps
(
    idTemps number constraint temps_pk PRIMARY KEY,
    jHomme number (3),
    idProj number constraint temps_idProj_fk FOREIGN KEY (idProj) REFERENCES Projet(idProj),
    idDis number constraint temps_idDis_fk FOREIGN KEY (idDis) REFERENCES Discipline(idDis)
);



CREATE SEQUENCE Entreprise_seq_idEnt 
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Projet_seq_idProj
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Travail_seq_idTrav
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Membre_seq_idMem
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Competence_seq_idComp
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Niveau_seq_idNiv
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Discipline_seq_idDis
INCREMENT BY 1
START WITH 1;

CREATE SEQUENCE Temps_seq_idTemps
INCREMENT BY 1
START WITH 1;

/* Faire avce trigger!!!  */

CREATE OR REPLACE TRIGGER before_insert_entreprise BEFORE INSERT 
ON Entreprise FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idEnt is null then 
        SELECT Entreprise_seq_idEnt.NEXTVAL INTO :NEW.IDENT FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_projet BEFORE INSERT 
ON Projet FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idProj is null then 
        SELECT Projet_seq_idProj.NEXTVAL INTO :NEW.IDProj FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_travail BEFORE INSERT 
ON Travail FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idTrav is null then 
        SELECT Travail_seq_idTrav.NEXTVAL INTO :NEW.IDTRAV FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_membre BEFORE INSERT 
ON Membre FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idMem is null then 
        SELECT Membre_seq_idmem.NEXTVAL INTO :NEW.IDMem FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_competence BEFORE INSERT 
ON Competence FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idcomp is null then 
        SELECT Competence_seq_idcomp.NEXTVAL INTO :NEW.IDCOMP FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_niveau BEFORE INSERT 
ON Niveau FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idniv is null then 
        SELECT Entreprise_seq_idNiv.NEXTVAL INTO :NEW.IDNIV FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_discipline BEFORE INSERT 
ON Discipline FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.iddis is null then 
        SELECT Discipline_seq_iddis.NEXTVAL INTO :NEW.IDDIS FROM DUAL;
    END IF;    
END;

CREATE OR REPLACE TRIGGER before_insert_temps BEFORE INSERT 
ON Temps FOR EACH ROW
BEGIN 
    IF INSERTING AND :new.idTemps is null then 
        SELECT Temps_seq_idTemps.NEXTVAL INTO :NEW.IDTemps FROM DUAL;
    END IF;    
END;