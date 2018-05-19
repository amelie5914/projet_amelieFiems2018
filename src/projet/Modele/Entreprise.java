/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;

/**
 *
 * @author ameliefiems
 */
public class Entreprise {
    private String nomEnt;
    private String telEnt;
    private String adresse;
    public Entreprise(){
        nomEnt="";
        telEnt="";
        adresse="";
    }
    public Entreprise(String nomEnt){
        this.nomEnt=nomEnt;
        telEnt="";
        adresse="";
    }
    public Entreprise(String nomEnt, String telEnt, String adresse) {
        this.nomEnt = nomEnt;
        this.telEnt = telEnt;
        this.adresse = adresse;
    }
    public String getNom(){
        return nomEnt;
    }
    public String getTel(){
        return telEnt;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nomEnt) {
        this.nomEnt = nomEnt;
    }

    public void setTelEnt(String telEnt) {
        this.telEnt = telEnt;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nomEnt);
        hash = 29 * hash + Objects.hashCode(this.telEnt);
        hash = 29 * hash + Objects.hashCode(this.adresse);
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
        final Entreprise other = (Entreprise) obj;
        if (!Objects.equals(this.nomEnt, other.nomEnt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "nomEnt=" + nomEnt + ", telEnt=" + telEnt + ", adresse=" + adresse + '}';
    }

    

    

 
}
