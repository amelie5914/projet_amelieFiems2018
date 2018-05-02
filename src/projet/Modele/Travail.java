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
public class Travail {
    private String dateEng;
    private int taux;
    private Projet proj;
    private Membre mem;
    public Travail(){
        
    }
    public Travail(String dateEng, int taux, Projet proj, Membre mem) {
        this.dateEng = dateEng;
        this.taux = taux;
        this.proj = proj;
        this.mem = mem;
    }
    public Travail(String dateEng){
        this.dateEng=dateEng;
        taux=0;
        proj=null;
        mem=null;
    }
    public Travail(Membre m){
        this.dateEng="";
        this.taux=0;
        this.proj=null;
        this.mem=m;
        
    }

    public String getDateEng() {
        return dateEng;
    }

    public int getTaux() {
        return taux;
    }

    @Override
    public String toString() {
        return "Travail{" + "dateEng=" + dateEng + ", taux=" + taux + ", proj=" + proj + ", mem=" + mem + '}';
    }

    public Projet getProj() {
        return proj;
    }

    public Membre getMem() {
        return mem;
    }

    public void setDateEng(String dateEng) {
        this.dateEng = dateEng;
    }

    public void setTaux(int taux) {
        this.taux = taux;
    }

    public void setProj(Projet proj) {
        this.proj = proj;
    }

    public void setMem(Membre mem) {
        this.mem = mem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.dateEng);
        hash = 97 * hash + this.taux;
        hash = 97 * hash + Objects.hashCode(this.proj);
        hash = 97 * hash + Objects.hashCode(this.mem);
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
        final Travail other = (Travail) obj;
        if (!Objects.equals(this.dateEng, other.dateEng)) {
            return false;
        }
        return true;
    }

   
    
    
    
}
