/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;
import java.util.Set;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ameliefiems
 */
public class Niveaux {
    private int degre;
    private String signification;
    public Niveaux(){
        
    }
    public Niveaux(int degre, String signification) {
        this.degre = degre;
        this.signification = signification;
    }
   public Niveaux(int degre){
       this.degre=degre;
       signification="";
       
   }
   public SimpleStringProperty getpDegre(){
        return new SimpleStringProperty(Integer.toString(degre));
    }
   public SimpleStringProperty getpSignification(){
        return new SimpleStringProperty(signification);
    }
    public int getDegre() {
        return degre;
    }

    public String getSignification() {
        return signification;
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }

    public void setSignification(String signification) {
        this.signification = signification;
    }
    
    @Override
    public String toString() {
        return "Niveaux{" + "degre=" + degre + ", signification=" + signification + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.degre;
        hash = 83 * hash + Objects.hashCode(this.signification);
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
        final Niveaux other = (Niveaux) obj;
        if (this.degre != other.degre) {
            return false;
        }
        if (!Objects.equals(this.signification, other.signification)) {
            return false;
        }
        return true;
    }

    
   
    
}
