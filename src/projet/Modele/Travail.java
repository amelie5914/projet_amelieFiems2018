/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

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
    
}
