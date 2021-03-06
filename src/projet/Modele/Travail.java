/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ameliefiems
 */
public class Travail {

    private String dateEng;
    private int taux;
    private ProjetGeneral proj;
    private Membre mem;

    public Travail() {

    }

    public Travail(String dateEng, int taux, ProjetGeneral proj, Membre mem) {
        this.dateEng = dateEng;
        this.taux = taux;
        this.proj = proj;
        this.mem = mem;
    }

    public Travail(String dateEng) {
        this.dateEng = dateEng;
        taux = 0;
        proj = null;
        mem = null;
    }

    public Travail(Membre m) {
        this.dateEng = "";
        this.taux = 0;
        this.proj = null;
        this.mem = m;

    }

    public String getDateEng() {
        return dateEng;
    }

    public int getTaux() {
        return taux;
    }
    public SimpleStringProperty getpDateEng(){
        return new SimpleStringProperty(dateEng);
    }
    public SimpleIntegerProperty getpTaux(){
        return new SimpleIntegerProperty(taux);
    }
    @Override
    public String toString() {
        return  "dateEng=" + dateEng + ", taux=" + taux + ", proj=" + proj + ", mem=" + mem ;
    }

    public ProjetGeneral getProj() {
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

    public void setProj(ProjetGeneral proj) {
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
