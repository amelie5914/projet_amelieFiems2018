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
    
    public int getJHomme(){
        return jHomme;
    }
}

