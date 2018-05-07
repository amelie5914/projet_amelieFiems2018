/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ameliefiems
 */
public abstract class ProjetGeneral {
    protected String titre;
    
    protected String dateDebut;
    protected String dateFin;
    protected double coutMax=0; 
    protected Entreprise ent;
    /*public Set<Temps> temps;
    public Set<Discipline> discipline;
    public Set<Membre> membre;
    */
    public ProjetGeneral(){
        this.dateDebut="";
        this.dateFin="";
        this.ent=null;
        this.titre="";
    }
    public ProjetGeneral(String titre){
        this.titre=titre;
        dateDebut="";
        dateFin="";
        ent=null;
    }
    public ProjetGeneral(String titre, String dateDebut, String dateFin,Entreprise ent) {
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.ent = ent;
    }
    public ProjetGeneral(Entreprise e){
        this.titre = "";
        this.dateDebut ="";
        this.dateFin = "";
        this.ent = e;
    }

    public String getTitre() {
        return titre;
    }

    public Entreprise getEnt() {
        return ent;
    }

    public double getCoutMax() {
        return coutMax;
    }

    

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setEnt(Entreprise ent) {
        this.ent = ent;
    }

    public void setCoutMax(double coutMax) {
        this.coutMax = coutMax;
    }

    
    @Override
    public String toString() {
        return "Projet{" + "titre=" + titre + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", ent=" + ent + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.titre);
        hash = 83 * hash + Objects.hashCode(this.dateDebut);
        hash = 83 * hash + Objects.hashCode(this.dateFin);
        hash = 83 * hash + Objects.hashCode(this.ent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjetGeneral other = (ProjetGeneral) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }

    
    
    
}
