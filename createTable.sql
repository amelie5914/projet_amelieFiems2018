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
    telMem varchar2(12) constraint mem_tel_check CHECK(regexp_like(telMem
,'^0[[:digit:]]{2}\/[[:digit:]]{2}\.[[:digit:]]{2}\.[[:digit:]]{2}$'),
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

