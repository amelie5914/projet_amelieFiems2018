/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Set;

/**
 *
 * @author ameliefiems
 */
public class Discipline {
    

    private String nomdiscipline;
    public Discipline(){
        
    }
    public Discipline(String nomdiscipline) {
        this.nomdiscipline = nomdiscipline;
    }

    @Override
    public String toString() {
        return "Discipline{" + "nomdiscipline=" + nomdiscipline + '}';
    }

    public String getNomdiscipline() {
        return nomdiscipline;
    }
    
    
}