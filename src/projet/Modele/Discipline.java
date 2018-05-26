/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;
import java.util.Set;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ameliefiems
 */
public class Discipline {
    
    private String nomdiscipline;
    public Discipline(){
        this.nomdiscipline="";
    }
    public Discipline(String nomdiscipline) {
        this.nomdiscipline = nomdiscipline;
    }

    @Override
    public String toString() {
        return  "nom=" + nomdiscipline ;
    }

    public String getNomdiscipline() {
        return nomdiscipline;
    }

    public void setNomdiscipline(String nomdiscipline) {
        this.nomdiscipline = nomdiscipline;
    }
    public SimpleStringProperty getpNom(){
        return new SimpleStringProperty(nomdiscipline);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nomdiscipline);
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
        final Discipline other = (Discipline) obj;
        if (!Objects.equals(this.nomdiscipline, other.nomdiscipline)) {
            return false;
        }
        return true;
    }
    
    
}