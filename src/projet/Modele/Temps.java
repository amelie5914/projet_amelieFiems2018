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
public class Temps {
    private int jHomme;
    private Projet proj;
    private Discipline dis;
    public Temps(){
        
    }
    public Temps(int jHomme, Projet proj, Discipline dis) {
        this.jHomme = jHomme;
        this.proj = proj;
        this.dis = dis;
    }
    public Temps(int jHomme){
        this.jHomme=jHomme;
        this.proj=null;
        this.dis=null;
    }
    public int getJHomme(){
        return jHomme;
    }

    @Override
    public String toString() {
        return "Temps{" + "jHomme=" + jHomme + ", proj=" + proj + ", dis=" + dis + '}';
    }

    public int getjHomme() {
        return jHomme;
    }

    public Projet getProj() {
        return proj;
    }

    public Discipline getDis() {
        return dis;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.jHomme;
        hash = 89 * hash + Objects.hashCode(this.proj);
        hash = 89 * hash + Objects.hashCode(this.dis);
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
        final Temps other = (Temps) obj;
        if (this.jHomme != other.jHomme) {
            return false;
        }
        return true;
    }
    
}

