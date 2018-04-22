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
public class Competence {
    private int degre;
    public Discipline discipline;
    public Niveaux niveau;
    public Membre mem;
    public Competence(){
        
    }
    public Competence (int degre){
        this.degre=degre;
        this.discipline=null;
        this.mem=null;
        this.niveau=null;
    }
    public Competence(int degre, Discipline discipline, Niveaux niveau, Membre mem) {
        this.degre = degre;
        this.discipline = discipline;
        this.niveau = niveau;
        this.mem = mem;
    }

    public int getDegre() {
        return degre;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Niveaux getNiveau() {
        return niveau;
    }

    public Membre getMem() {
        return mem;
    }

    @Override
    public String toString() {
        return "Competence{" + "degre=" + degre + ", discipline=" + discipline + ", niveau=" + niveau + ", mem=" + mem + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.degre;
        hash = 59 * hash + Objects.hashCode(this.discipline);
        hash = 59 * hash + Objects.hashCode(this.niveau);
        hash = 59 * hash + Objects.hashCode(this.mem);
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
        final Competence other = (Competence) obj;
        if (this.degre != other.degre) {
            return false;
        }
        return true;
    }
    
    

    
}
