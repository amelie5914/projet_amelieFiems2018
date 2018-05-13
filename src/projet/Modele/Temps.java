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
    private ProjetGeneral proj;
    private Discipline dis;
    private int jHommeTotal;
    public Temps(){
        
    }
    public Temps(int jHomme, ProjetGeneral proj, Discipline dis) {
        this.jHomme = jHomme;
        this.proj = proj;
        this.dis = dis;
        if(proj instanceof ProjetSimple){
         this.jHommeTotal=jHomme;
        }
        this.jHommeTotal=jHommeTotal+jHomme;
    }
    public Temps(int jHomme){
        this.jHomme=jHomme;
        this.proj=null;
        this.dis=null;
    }
    

    @Override
    public String toString() {
        return "Temps{" + "jHomme=" + jHomme + ", proj=" + proj + ", dis=" + dis + '}';
    }

    public int getjHomme() {
        return jHomme;
    }

    public ProjetGeneral getProj() {
        return proj;
    }

    public Discipline getDis() {
        return dis;
    }

    public int getjHommeTotal() {
        return jHommeTotal;
    }
    
    public void setjHomme(int jHomme) {
        this.jHomme = jHomme;
    }

    public void setProj(ProjetGeneral proj) {
        this.proj = proj;
    }

    public void setDis(Discipline dis) {
        this.dis = dis;
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
        if (!Objects.equals(this.proj, other.proj)) {
            return false;
        }
        if (!Objects.equals(this.dis, other.dis)) {
            return false;
        }
        return true;
    }

    
    
}

